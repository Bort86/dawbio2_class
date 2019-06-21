<?php

require_once "model/UserModelInterface.class.php";
require_once "model/persist/ConnectFile.class.php";

class UserFileDAO implements UserModelInterface {

    private static $instance = NULL; // instancia de la clase
    private $connect; // conexión actual

    const FILE = "model/resource/users.txt";

    public function __construct() {
        $this->connect = new ConnectFile(self::FILE);
    }

    // singleton: patrón de diseño que crea una instancia única
    // para proporcionar un punto global de acceso y controlar
    // el acceso único a los recursos físicos
    public static function getInstance(): UserFileDAO {
        if (is_null(self::$instance)) {
            self::$instance = new self();
        }
        return self::$instance;
    }

    /**
     * insert a product in file
     * @param $product Product object to insert
     * @return TRUE or FALSE
     */
    public function add($user): bool {
        $result = FALSE;

        // abre el fichero en modo append
        if ($this->connect->openFile("a+")) {
            fputs($this->connect->getHandle(), $user->__toString());
            $this->connect->closeFile();
            $result = TRUE;
        }

        return $result;
    }

    /**
     * update a product in file
     * @param $product Product object to update
     * @return TRUE or FALSE
     */
    public function modify($user): bool {
        $result = FALSE;
        $fileData = array();

        if ($this->connect->openFile("r")) { //abrir en modo lectura
            while (!feof($this->connect->getHandle())) {
                $line = trim(fgets($this->connect->getHandle()));
                if ($line != "") {
                    $fields = explode(";", $line);

                    if ($user->getUsername() == $fields[0]) {
                        array_push($fileData, $user->__toString());
                    } else {
                        array_push($fileData, $line . "\n");
                    }
                }
            }
            $this->connect->closeFile();
        }
        if ($this->connect->writeFile($fileData)) {
            $result = TRUE;
        }
        return $result;
    }

    /**
     * delete a category in file
     * @param $id string Product Id to delete
     * @return TRUE or FALSE
     */
    public function delete($username): bool {
        $result = FALSE;
        $fileData=array();
           
        if ($this->connect->openFile("r")) {
            while (!feof($this->connect->getHandle())) {
                $line = trim(fgets($this->connect->getHandle()));
                if ($line != "") {
                    $fields = explode(";", $line);
                     echo $line.$username.$fields[0]."<br/>";
                    if ($username != $fields[0]) {
                        array_push($fileData, $line . "\n");
                        echo $line.$username.$fields[0]."<br/>";
                        
                    }
                }
            }
            $this->connect->closeFile();
        }
        if ($this->connect->writeFile($fileData)) {
            $result=TRUE;
        }
        return $result;
    }
    
    

    /**
     * select all categories from file
     * @param void
     * @return array of Category objects or array void
     */
    public function listAll(): array {
        $result = array(); //guardo las categorías en un array
        // abre el fichero en modo read
        if ($this->connect->openFile("r")) {
            while (!feof($this->connect->getHandle())) {
                $line = trim(fgets($this->connect->getHandle()));
                if ($line != "") {
                    $fields = explode(";", $line);
                    $user = new User($fields[0], $fields[1], $fields[2], $fields[3], $fields[4], $fields[5]);
                    array_push($result, $user);
                }
            }
            $this->connect->closeFile();
        }

        return $result;
    }

    /**
     * select a category by Id from file
     * @param $id string Category Id
     * @return Category object or NULL
     */
    public function searchById($username) {
        $user = NULL;

        if ($this->connect->openFile("r")) {
            while (!feof($this->connect->getHandle())) {
                $line = trim(fgets($this->connect->getHandle()));
                if ($line != "") {
                    $fields = explode(";", $line);
                    if ($username == $fields[0]) {
                        $user = new User($fields[0], $fields[1], $fields[2], $fields[3], $fields[4], $fields[5]);
                        break;
                    }
                }
            }
            $this->connect->closeFile();
        }
        return $user;
    }
    
     public function findByUsername($username) {
        
        $user = NULL;

        // abre el fichero en modo read
        if ($this->connect->openFile("r")) {
            while(!feof($this->connect->getHandle())) {
                $line=trim(fgets($this->connect->getHandle()));
                if ($line!="") {
                    $fields=explode(";", $line); //separa por ; i te deja cada cacho en una posición array
                    
                    if (is_numeric(stripos($fields[0], $username))) {
                        $user = new User($fields[0], $fields[1], $fields[2], $fields[3], $fields[4], $fields[5]);
                        break;
                    }      
                }
            }
            $this->connect->closeFile();
        }

        return $user;
    } 
    

}
