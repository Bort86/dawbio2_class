<?php

class User {

    private $username;
    private $password;
    private $age;
    private $role;
    private $active;  //category object or category id
    private $department;
  

    public function __construct($username = NULL, $password = NULL, $age = NULL, $role = NULL, $active = NULL,$department) {
        $this->username = $username;
        $this->password = $password;
        $this->age = $age;
        $this->role = $role;
        $this->active = $active;
        $this->department = $department;
    }

    public function getUsername() {
        return $this->username;
    }

    public function setUsername($username) {
        $this->username = $username;
    }

    public function getPassword() {
        return $this->password;
    }

    public function setPassword($password) {
        $this->password = $password;
    }

    function getAge() {
        return $this->age;
    }

    function setAge($age) {
        $this->age = $age;
    }

    function getRole() {
        return $this->role;
    }

    function setRole($role) {
        $this->role = $role;
    }

    function getActive() {
        return $this->active;
    }

    function setActive($active) {
        $this->active = $active;
    }

    function getDepartment() {
        return $this->department;
    }

    function setDepartment($department) {
        $this->department = $department;
    }
    
    public function __toString() {
        return sprintf("%s;%s;%d;%s;%d;%s\n", $this->username, $this->password, $this->age, $this->role, $this->active,$this->department);
    }

}
