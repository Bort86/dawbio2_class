<?php
class UserView {
    
    public function __construct() {

    }

    public function display($template=NULL, $content=NULL,$roles=NULL,$departments=NULL) {
        include("view/menu/MainMenu.html");
        //include("view/menu/CategoryMenu.html");

        if (!empty($template)) {
            include($template);
        }
        
        include("view/form/MessageForm.php");
    }    

}
