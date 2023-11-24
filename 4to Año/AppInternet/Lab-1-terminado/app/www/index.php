
<html>
    <head>
        <title>Aplicaciones de Internet</title>
        <meta charset="utf-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <h1>Aplicaciones de Internet</h1>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th></th>
                            <th>id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                        </tr>
                    </thead>
                    <?php
                    
                        if($_SERVER["REQUEST_METHOD"] == "POST"){
                            if(!empty($_POST['name']) && !empty($_POST['last_name'])){
                                $conn = mysqli_connect('db', 'root', 'test', "dbname");
                                $name = $_POST['name'];
                                $last_name = $_POST['last_name'];
                                $insert = "INSERT INTO Person(name,last_name) VALUES('$name','$last_name')";
                                $result = mysqli_query($conn,$insert);

                                if(!$result){
                                    echo 'Error no se a agregado correctamente';
                                }
                                else{
                                    echo 'Agregado correctamente';
                                }
                                mysqli_close($conn);
                            }
                            else{
                                echo 'Error los campos no pueden estar vacios';
                            }
                            
                        }

                        $conn = mysqli_connect('db', 'root', 'test', "dbname");
                        $query = 'SELECT * From Person';
                        $result = mysqli_query($conn, $query);

                        while($value = $result->fetch_array(MYSQLI_ASSOC)){
                            echo '<tr>';
                            echo '<td><a href="#"><span class="glyphicon glyphicon-search"></span></a></td>';
                            foreach($value as $element){
                                echo '<td>' . $element . '</td>';
                            }
                            
                            echo '</tr>';
                        }

                        $result->close();
                        mysqli_close($conn);
                    ?>
                    </table>
                    <form action="" method="post">
                        <h3>Nombre</h3>    
                        <input type="text" name="name" placeholder="Ingrese su Nombre">
                        <h3>Apellido</h3>
                        <input type="text" name="last_name" placeholder="Ingrese su Apellido">
                        <button type="submit" name="Register">Agregar</button>
                </form>
            </div>
        </div>
    </body>
</html>
