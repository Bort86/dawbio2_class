<?php

class Role {

    private $id;
    private $name;
   
  

    public function __construct($id = NULL, $name = NULL) {
        $this->id = $id;
        $this->name = $name;
        
    }

    public function getName() {
        return $this->name;
    }

    public function setName($name) {
        $this->name = $name;
    }


    function getId() {
        return $this->id;
    }

    function setId($id) {
        $this->id = $id;
    }

    
    
    public function __toString() {
        return sprintf("%d;%s\n", $this->id, $this->name);
    }

}
