<?php

require_once "model/RoleModelInterface.class.php";
require_once "model/persist/ConnectFile.class.php";

class RoleFileDAO implements RoleModelInterface {

    private static $instance = NULL; // instancia de la clase
    private $connect; // conexión actual

    const FILE = "model/resource/roles.txt";

    public function __construct() {
        $this->connect = new ConnectFile(self::FILE);
    }

    // singleton: patrón de diseño que crea una instancia única
    // para proporcionar un punto global de acceso y controlar
    // el acceso único a los recursos físicos
    public static function getInstance(): RoleFileDAO {
        if (is_null(self::$instance)) {
            self::$instance = new self();
        }
        return self::$instance;
    }

   /*
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
                    $role = new Role($fields[0], $fields[1]);
                    array_push($result, $role);
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
    public function searchById($id) {
        $role = NULL;
      
        if ($this->connect->openFile("r")) {
            while (!feof($this->connect->getHandle())) {
                $line = trim(fgets($this->connect->getHandle()));
                if ($line != "") {
                    $fields = explode(";", $line);
                    if ($id == $fields[0]) {
                        $role = new Role($fields[0], $fields[1]);
                        break;
                    }
                }
            }
            $this->connect->closeFile();
        }
        return $role;
    }
    
    
}
