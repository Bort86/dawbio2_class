<div id="content">
    <form method="post" action="">
        <fieldset>
            <legend>Add user</legend>
            <label>Username *:</label>
            <input type="text" placeholder="Username" name="username" value="<?php if (isset($content)) { echo $content->getUsername(); } ?>" />
            <label>Password *:</label>
            <input type="password" placeholder="Password" name="pass" value="<?php if (isset($content)) { echo $content->getPassword(); } ?>" />
            <label>Age :</label>
            <input type="number" placeholder="Age" name="age" value="<?php if (isset($content)) { echo $content->getAge(); } ?>" />
            <label>Role:</label>
            <select name="role">
            <option value=""></option>
            <?php 
             foreach ($roles as $role) {
                 $selected="";
                 if(isset($content)){
                     
                     if($role->getId()==$content->getRole()){
                         $selected="selected";
                     }
                 }
                echo "<option value='{$role->getId()}' $selected>{$role->getName()}</option>";
             }
            ?>
             
            </select>
            <label>Department:</label>
            <select name="department">
            <option value=""></option>
            <?php 
             foreach ($departments as $department) {
                 $selected="";
                 if(isset($content)){
                     
                     if($department==$content->getDepartment()){
                         $selected="selected";
                     }
                 }
                echo "<option value='{$department}' $selected>{$department}</option>";
             }
            ?>
             
            </select>
                 
                      
            <label>* Required fields</label>
            <input type="submit" name="action" value="add" />           
        </fieldset>
    </form>
</div>