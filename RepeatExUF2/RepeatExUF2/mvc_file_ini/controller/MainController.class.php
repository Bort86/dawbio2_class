<?php
require_once "controller/UserController.class.php";


class MainController {

    // carga la vista según la opción
    public function processRequest() {

        //$request=filter_has_var(INPUT_GET, 'menu')?filter_input(INPUT_GET, 'menu'):NULL;

        $request=NULL;
        // recupera la opción de un menú
        if (filter_has_var(INPUT_GET, 'menu')) {
            $request=filter_input(INPUT_GET, 'menu');
        }

        switch ($request) {
            // categorías
            case "user":
                $controlUser=new UserController();
                $controlUser->processRequest();
                break;
            // productos
            
            default:
                $controlUser=new UserController();
                $controlUser->processRequest();
                break;
        }

    }
    
}
