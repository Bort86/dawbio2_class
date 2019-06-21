<div id="content">
    <form method="post" action="">
        <fieldset>
            <legend>Modify user</legend>
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
            <label>Active *:</label>   
            <?php 
            $checked_yes="";
            $checked_no="";
            
            if (isset($content)) { 
                if($content->getActive()==1){
                    $checked_yes="checked";
                }else{
                    $checked_no="checked";
                }              
                
            } ?>
            
            <input type="radio" name="active" value="1" <?php echo $checked_yes; ?>/>YES          
            <input type="radio" name="active" value="0" <?php echo $checked_no;  ?> />NO 
           
            
<!--        Otra manera más elegante
            <input type="radio" name="active1" value="1" <?php //echo ($content->getActive()==1) ? 'checked' : ''; ?>/>YES          
            <input type="radio" name="active1" value="0" <?php //echo ($content->getActive()==0) ? 'checked' : ''; ?> />NO 
           -->
            
            
            <label>* Required fields</label>
            <input type="submit" name="action" value="modify" />
            <button name="action" value="delete" onClick="form_delete(this.form.id);return false;">delete</button> 
                      
        </fieldset>
    </form>
</div>