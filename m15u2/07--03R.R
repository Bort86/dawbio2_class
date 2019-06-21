#Listas (List)

# Estructuras de almacenamientos de objetos que pueden ser de diferentes clases(tipos): numéricos, caracteres, vectores, matrices, funciones, dataframes, array, list,  etc.

# Los componentes de las listas pueden tener un número de elementos diferentes (los objetos que almacena pueden ser de dimensiones diferentes)

# Se crean con la función list()

# Acceso [], [[]], $


#Ejemplo de lista y operadores
lista1 <- list(c(1,2,3), c("d", "e", "f", "o"), mean, matrix(rep(0,16), nrow=4))
lista1
lista2 <- list(rep('angel', 5), 1:20)
lista2
lista2[1]
class(lista2[[1]])
length(lista2[[2]])
lista2[1:2]
str(lista2)

#forma de declarar una lista vacía con vector
x1 <- vector('character', 2)
x1
x2 <- vector('list', 2)
x2
class(x2)
x2[[1]] <- rep('angel', 3)
x2[[2]]<- 1:20
x2
?list

#darle nombres a los elementos de una lista
lista3<- list(nombre = rep('angel',3), numeros=1:20)
lista3

#otra manera de declarar una lista y darle nombre a sus elementos
lista4 <- NULL
lista4
names(lista4)
lista4$nombre <- rep('angel', 3)
lista4$numeros <- 1:20
lista4
class(lista4)
lista4$numeros[7]
names(lista4)[1] <- 'nom'
# crear una lista con dos objetos y sin nombres: el primero con 4 veces 'pablo' y la otra con el abecedario
# luego le ponemos nombres
lista5 <- list(rep('pablo', 4), letters)
lista5
names(lista5)[1]<-'profe'
names(lista5)[2]<- 'LETRAS'
names(lista5)
lista5
# las listas son útiles para agrupar varios tipos de datos ya que no es restrictiva como las matrices

## DATA FRAME ##
# Es un tipo especial de lista, donde todos los objetos tienen el mismo nº de elementos,
# pero mantiene la libertad de que las clases de los objetos pueden ser diferentes.
# Es una tabla de datos ---> columnas = "variables"
#                       ---> filas = "observaciones"

#declaración
# el primer parámetro son los valores de la primera columna, el segundo los valores de la segunda columna
data1 <- data.frame(12:23, seq(.1, 1.2, by=.1))
data1

#asignamos nombre a las estructuras de la tabla
names(data1)[1] <- "enteros"
names(data1)[2] <- "Decimales"
data1 <- data.frame(enteros = 12:23, decimales = seq(.1, 1.2, by=.1))

class(data1)
class(data1$enteros)
class(data1[[1]])
summary(data1)
str(data1)

#data3, dos columnas sin nombre, la primera con las diez primeras letras, la segunda con los 10 primeros números naturales
data3 <- data.frame(letters[1:10], 1:10)
data3
class(data3)
colnames(data3)
rownames(data3)
names(data3)[1] <- "letras"
names(data3)[2] <- "enteros"
colnames(data3)<- c("letricas", "entericos")
rownames(data3)<- seq(0.5, 5, by=0.5)

#crear una tabla con 4 variables: nombre, edad, presion, sexo
nombres <- c("nom1", "nom2", "nom3")
edad <- seq(22, 24, by=1)
presion <- c(7, 12, 8)
sexo <- c("H", "H", "M")
data4 <- data.frame(nombres, edad, presion, sexo)
data4
str(data4)
names(data4)
nrow(data4)
ncol(data4)

# Acceso
data4[1,3] # coje de la primera fila, la tercera columna, 1,3
data4[1:2,3] #coje de la tercera columna, los elementos 1 al 2
data4[["edad"]]
data4[2,"edad"]      

#es común transformar una matriz a dataframe
m <- matrix(1:25, 5, 5, byrow=TRUE)
m
class(m)
mm <- as.data.frame(m)
mm

# se suelen importar objetos r a tablas
library(help='datasets')
str(cars)

#añadir la variable Area.Petalo a n.iris con cbind
str(iris)
iris
names(iris)
Area.Petalo <- seq(iris$Petal.Length*iris$Petal.Width)
Area.Petalo
n.iris <- iris
?cbind
cbind(n.iris, Area.Petalo)
plot(n.iris)
plot(Petal.Length ~ Petal.Width, data = iris, col=rep(1:3, each=50) )
dev.off()
#####################################     FACTORS     ###################################################

# Es una variable categórica con un número finito de valores o nivel (Ej: sexo)
# Se utilizan para realizar clasificaciones de los datos, estableciendo su pertinencia a una de las categorías
# Los niveles de un factor pueden ser codificados como numéricos o como carácteres pero internamente todos son numéricos
# Un factor tiene 2 vectores:
# 1. Índices enteros que sustituyen al vector original de caracteres
# 2. Es un vector que contiene los niveles

sexo <- c("M", "H", "M", "M", "H", "H")
persona <- c("pepe", "pablo", "pipo", "pancracio", "pomodoro", "plutarco")

paste(persona[3], " es de sexo ", sexo[2])

# convertir a factor
fsexo <- as.factor(sexo)
fsexo
class(fsexo)
typeof(fsexo)

table(fsexo)
table(sexo) #ojo, table se adapta y se "huele" que en realidad le pasamos un factor

fsexo[3]
levels(fsexo)
levels(fsexo)[2]
levels(fsexo)[2] <- "Mujer"  # cambiamos el valor
levels(fsexo)[1] <- "Hombre"

f1sexo <- factor(sexo, levels=c("H", "M"), labels=c("Hombra", "Mujera"))
f1sexo <- factor(sexo, levels(fsexo), labels=c("Hombra", "Mujera")) ## los levels los podemos coger de pasar a factor la variable 'sexo'
f1sexo

###############################   CLASIFICACIÓN DE VARIABLES  #####################################

# 1- Cuantitativas : tienen magnitud numérica
#   a. discretas: (nº hijos, nº alumnos)
#   b. continuas: toma un número de valores infinitos en un rango

# 2- Cualitativas : tienen un atributo no cuantificable numéricamente
#   a. nominales: su valor no corresponde a ninguna jerarquía (nombres de personas, grupos sanguíneos)
#   b. ordinales: su valor presenta una cierta jerarquía, orden o progresión (días de la semana)
