<?php
require_once "model/persist/UserFileDAO.class.php";

//require_once "model/persist/CategoryDbDAO.class.php";

class UserModel {

    private $dataUser;

    public function __construct() {
        // File
        $this->dataUser=UserFileDAO::getInstance();
        
        // Database
        //$this->dataCategory=CategoryDbDAO::getInstance();
    }

    /**
     * insert a product
     * @param $product Product object to insert
     * @return TRUE or FALSE
     */
    public function add($user):bool {
        $result=$this->dataUser->add($user);
        
        if ($result==FALSE) {
            $_SESSION['error']=UserMessage::ERR_DAO['insert'];
        }
        
        return $result;
    }

    /**
     * update a product
     * @param $product Product object to update
     * @return TRUE or FALSE
     */
    public function modify($user):bool {
        $result= $this->dataUser->modify($user);
        
        if($result==FALSE) {
            $_SESSION['error']= UserMessage::ERR_DAO['update'];
        }
        return $result;
    }

    /**
     * delete a product
     * @param $id string Product Id to delete
     * @return TRUE or FALSE
     */    
    public function delete($username):bool { 
        
        $result=FALSE;
        
       $result=$this->dataUser->delete($username);

        
            if ($result==FALSE) {
                $_SESSION['error']=UserMessage::ERR_DAO['delete'];
            } 
       
        
        return $result;
    }

    /**
     * select all products
     * @param void
     * @return array of Product objects or array void
     */    
    public function listAll():array { //para pasarle la categoría a la lista de productos
        $result=array();
        $users=$this->dataUser->listAll();
        
         $roleModel = new RoleModel();
        
        foreach ($users as $user){
            $role=$roleModel->searchById($user->getRole()); //transformes el num en objecte. Llegeixes del fitxer el id
            
            if (isset($role)){ 
                $user->setRole($role); //li asignes al user l'objecte corresponent al id que has recuperat del fitxer
            
            }
            else{
                $user->setRole(new Role);
            }
            array_push($result, $user);
        }
        return $result;
    }

    
    /**
    * select a product by Id
    * @param $id string Product Id
    * @return Product object or NULL
    */
    public function searchById($username) {
        
        $user= $this->dataUser->searchById($username);
                
        return $user;
    }    

      
     public function findByUsername($username) {
        
        $user= $this->dataUser->findByUsername($username);
                
        return $user;
    }    




}
