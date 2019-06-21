<?php
require_once "model/persist/RoleFileDAO.class.php";

//require_once "model/persist/CategoryDbDAO.class.php";

class RoleModel {

    private $dataRole;

    public function __construct() {
        // File
        $this->dataRole=RoleFileDAO::getInstance();
        
        // Database
        //$this->dataCategory=CategoryDbDAO::getInstance();
    }

   public function add($role){
       
   }
   
   public function modify($role){
       
   }
   
   public function delete($id){
       
   }



   /**
     * select all products
     * @param void
     * @return array of Product objects or array void
     */    
    public function listAll():array { //para pasarle la categoría a la lista de productos
        $roles=$this->dataRole->listAll();
        
        return $roles;
    }

    
    /**
    * select a product by Id
    * @param $id string Product Id
    * @return Product object or NULL
    */
    public function searchById($id) {
        
        $role= $this->dataRole->searchById($id);
                
        return $role;
    }    

      



}
