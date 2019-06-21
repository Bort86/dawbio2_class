<?php
interface RoleModelInterface {

    public function searchById($id);
    public function listAll():array;

}
