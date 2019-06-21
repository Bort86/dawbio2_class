<div id="content">
    <fieldset>
        <legend>User list</legend>    
        <?php
            if (isset($content)) {
                echo <<<EOT
                    <table>
                        <tr>
                            <th>Selection</th>
                            <th>Username</th>                         
                            <th>Age</th>
                            <th>Role</th>
                            <th>Active</th>
                            <th>Department</th>
                        </tr>
EOT;
                foreach ($content as $user) {
                    echo <<<EOT
                        <tr>
                            <td><input type="radio" name="sel" id="id_sel" value=""/></td>
                            <td>{$user->getUsername()}</td>
                            <td>{$user->getAge()}</td>
                            <td>{$user->getRole()->getName()}</td>
                            <td>{$user->getActive()}</td>
                            <td>{$user->getDepartment()}</td>
                        </tr>
EOT;
                }
                echo <<<EOT
                    </table>
EOT;
            }
        ?>
    </fieldset>
    <fieldset>
        <legend>Actions</legend>
        <form method="post" action="">
        <input type="submit" name="action" value="form_add" />
        <input type="submit" name="action" value="search" />
        </form>
    </fieldset>
</div>
