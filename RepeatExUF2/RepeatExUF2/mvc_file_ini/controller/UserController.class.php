<?php

require_once "controller/ControllerInterface.php";
require_once "view/UserView.class.php";
require_once "model/UserModel.class.php";
require_once "model/RoleModel.class.php";
require_once "model/User.class.php";
require_once "model/Role.class.php";
require_once "util/UserMessage.class.php";
require_once "util/UserFormValidation.class.php";

class UserController implements ControllerInterface {

    private $view;
    private $model;
    private $rolemodel;

    public function __construct() {
        // carga la vista
        $this->view = new UserView();

        // carga el modelo de datos
        $this->model = new UserModel();
        
        $this->rolemodel = new RoleModel();
    }

    // carga la vista según la opción o ejecuta una acción específica
    public function processRequest() {

        $request = NULL;
        $_SESSION['info'] = array();
        $_SESSION['error'] = array();

        // recupera la acción de un formulario
        if (filter_has_var(INPUT_POST, 'action')) {
            $request = filter_has_var(INPUT_POST, 'action') ? filter_input(INPUT_POST, 'action') : NULL;
        }
        // recupera la opción de un menú
        else {
            $request = filter_has_var(INPUT_GET, 'option') ? filter_input(INPUT_GET, 'option') : NULL;
        }

        switch ($request) {
            case "form_add":
                $this->formAdd();
                break;
            case "add":
                $this->add();
                break;
            case "list":
                $this->listAll();
                break;
            case "mod_del":
                $this->formModify();
                break;
            case "modify":
                $this->modify();
                break;
            case "delete":
                $this->delete();
                break;
            case "search":
                $this->formSearch();
                break;
            case "searchUsername":
                $this->findByUsername();
                break;
            default:
                $this->view->display();
        }
    }

    // carga el formulario de insertar producto
    public function formAdd() {
        $roles= $this->rolemodel->listAll();
        $departments = array("informatica","bio");
        $this->view->display("view/form/UserFormAdd.php",NULL,$roles,$departments);
    }

    // ejecuta la acción de insertar producto
    public function add() {
        $roles= $this->rolemodel->listAll(); //$roles = array("basico","avanzado");
        $departments = array("informatica","bio");
       
        $userValid = UserFormValidation::checkData(UserFormValidation::ADD_FIELDS);

        if (empty($_SESSION['error'])) {
            $user = $this->model->searchById($userValid->getUsername()); //comprova que no existeix

            if (is_null($user)) {
                
                $result = $this->model->add($userValid);

                if ($result == TRUE) {
                    $_SESSION['info'] = UserMessage::INF_FORM['insert'];
                    $userValid = NULL;
                }
            } else {
                $_SESSION['error'] = UserMessage::ERR_FORM['exists_username'];
            }
        }

        $this->view->display("view/form/UserFormAdd.php", $userValid,$roles,$departments);
    }

    public function formSearch(){
        $this->view->display("view/form/UserFormSearch.php");
    }

    // carga el formulario de modificar categoria
    public function formModify() {
        $roles= $this->rolemodel->listAll();
        $departments = array("informatica","bio");
        $this->view->display("view/form/UserFormModify.php",NULL,$roles,$departments);
    }

    // ejecuta la acción de modificar producto    
    public function modify() {
        
$userValid=UserFormValidation::checkData(UserFormValidation::MODIFY_FIELDS);        
        
        if (empty($_SESSION['error'])) {
            $user=$this->model->searchById($userValid->getUsername());

            if (!is_null($user)) {            
                $result=$this->model->modify($userValid);

                if ($result == TRUE) {
                    $_SESSION['info']=UserMessage::INF_FORM['update'];
                }
            }
            else {
                $_SESSION['error']=UserMessage::ERR_FORM['not_exists_id'];
            }
        }
        $roles= $this->rolemodel->listAll();
        $departments = array("informatica","bio");
        $this->view->display("view/form/UserFormModify.php",NULL,$roles,$departments);
    }

    // ejecuta la acción de eliminar categoría    
    public function delete() {
        
        $userValid = UserFormValidation::checkData(UserFormValidation::DELETE_FIELDS);

        if (empty($_SESSION['error'])) {
            $user = $this->model->searchById($userValid->getUsername());

            if (!is_null($user)) {
                $result = $this->model->delete($userValid->getUsername());

                if ($result == TRUE) {
                    $_SESSION['info'] = UserMessage::INF_FORM['delete'];
                    $userValid = NULL;
                }
            } else {
                $_SESSION['error'] = UserMessage::ERR_FORM['not_exists_id'];
            }
        }

       $roles= $this->rolemodel->listAll();
        $departments = array("informatica","bio");
        $this->view->display("view/form/UserFormModify.php",NULL,$roles,$departments);
    }

    // ejecuta la acción de mostrar todas las categorías
    public function listAll() {
        $users = $this->model->listAll();

        if (!empty($users)) { // array void or array of Category objects?
            $_SESSION['info'] = UserMessage::INF_FORM['found'];
        } else {
            $_SESSION['error'] = UserMessage::ERR_FORM['not_found'];
        }

        $this->view->display("view/form/UserList.php", $users);
    }

    // ejecuta la acción de buscar categoría por id de categoría
    public function searchById() {
        $productValid = ProductFormValidation::checkData(ProductFormValidation::SEARCH_FIELDS);

        if (empty($_SESSION['error'])) {
            $product = $this->model->searchById($productValid->getId());

            if (!is_null($product)) { // is NULL or Category object?
                $_SESSION['info'] = ProductMessage::INF_FORM['found'];
                $productValid = $product;
            } else {
                $_SESSION['error'] = ProductMessage::ERR_FORM['not_found'];
            }
        }
        $categories=$this->model->listCategories();
        $this->view->display("view/form/ProductFormModify.php", $productValid,$categories);
    }

    // carga el formulario de buscar productos por nombre de categoría
    public function formListProducts() {
        $this->view->display("view/form/ProductFormSearchProduct.php");
    }

    public function findByUsername() {
        
         $userValid = UserFormValidation::checkData(UserFormValidation::SEARCH_FIELDS);
         
        //$users = $this->model->findByUsername($username);
        $roles= $this->rolemodel->listAll();
        $departments = array("informatica","bio");

        if (empty($_SESSION['error'])) {
            $user = $this->model->findByUsername($userValid->getUsername());

            if (!is_null($user)) { // is NULL or Category object?
                $_SESSION['info'] = UserMessage::INF_FORM['found'];
                $userValid = $user;
            } else {
                $_SESSION['error'] = UserMessage::ERR_FORM['not_found'];
            }
        }

        $this->view->display("view/form/UserFormModify.php", $userValid,$roles,$departments);
    }

}
