#################################### Estructuras de flujo ###################################

########### if -else
#   if (condición) {acción}
#   if () {acción} else {acción}
#   if () {acción} else if (condición) {acción}

nota <- 5
if (nota >= 5)
  print("aprobado")

nota <- 4
if (nota <=5) {  # instrucción compleja
  print("aprobado")
  print("Claro que sí")
}

nota <- 5
nota <- if (nota >= 5) "aprobado"
nota

nota <- 7.7
if (nota < 5) {
  print("suspenso")
} else if (nota >= 5 && nota < 6) {
  print("suficiente")
} else if (nota >= 6) {
  print("notable")
}

############### LOOPS  ###############
# for (){}
# for (i in listadevalores) {secuencia de comandos}
for (i in 1:12){
  print(i)
}

for (i in 1:12){
  if ( i == 6) break
  print(i)
}

#
bases <- c("A", "T", "C", "G") #c(), concatenar, devuelve un vector, que usa el orden de entrada: como se declare, permanece
for ( i in bases) {
  print(i)
}

#
seq_along(bases) # genera una secuencia de enteros que represetan a los índices de 'bases'

for (i in seq_along(bases)){
  print(bases[i])
}

for (i in letters){
  print(i)
}

#
matriz <- matrix(1:12, 4,3, byrow=TRUE)
matriz

for (i in matriz){ # ojo, printa usando columnas primero, no le afecta el byrow=true de la declaración de matriz
  print(i)
}

seq_along(matriz)
for (i in seq_along(matriz)){  #igual, printa por columna
  print(matriz[i])
}


#################### WHILE ###############
# Repeticiones mientras se cumple una condición
# while() {}
# while (condicion lógica) {expresiones a ejecutar} 

count <- 0
while (count < 10) {
  print(count)
  count <- count +1
}

bases <- c("A", "T", "C", "G")

count <- 1
while (count < 5) {
  print (bases[count])
  count <- count +1
}

#################### REPEAT #################### 
# repeat 
# repeat {} Inicia un bucle infinito, se sale con un break

count <- 1
repeat {
  print(bases[count])
  count <-  count+1
  if (count>4) {
    break
  }
}

# vectorización de los cálculos
# Conviene evitar los bucles tanto como sea posible
x <- 1:10
for (i in x) {
  y <- i^2
  print(y)
}

# pero mucho más eficiente es hacerlo así:
x <- 1:10
y <- x^2
y
system.time()

n <- 100000000
x <- 1:n
tiempo1 <- system.time({y<- integer(n)
for (i in 1:n) y[i] <- x[i]^2
})
tiempo1

tiempo2<- system.time({y<-x^2})
tiempo2

# calcular la hipotenusa
hipotenusa <- function(a,b) {
  return (sqrt(a^2 + b^2))
}
hipotenusa(3,4)

class(hipotenusa)
typeof(hipotenusa)

########### Números aleatorios ###########

# 2 funciones: sample y runif

# Generar una primitiva, 5 números al azar entre 1 y 49

sample(1:10, 12, replace = TRUE)

# para tener valores reproducibles declaramos una semilla
set.seed(123456)
sample(1:49,5)

# exacto es intentar estar cerca de lo deseado, preciso es obtener más datos
# generar 20 notas al azar con 2 decimales
?runif

runif(20, 1, 10)

notas <- round(runif(20,min=1,max=10),2)
notas

# cadena de 30 nucleótidos al azar

bases <- c("A", "T", "C", "G")
cadena <- sample(bases,30, replace=TRUE)
cadena
is.vector(cadena)
cadena[3]
cadena [3:8]

# generar cadena aleatoria con nombres de 10 colores

sizeCol<-length(colors())
colors()[sample(1:sizeCol,10, replace=TRUE)] # es como poner colors()[1]

table(cadena)
?table

######## GRÁFICOS #########

# Diagrama de barras >>>> barplot()
#         - variables cualitativas (nominales y ordinales)
#         - variables cuantitativas discretas
# Histograma >>>> hist()
#         - variables cuantitativas continuas
# Pie (pastelaco)>>>>> pie()

# construir el diagrama de barras para las especies de iris

head(iris)

iris$Species 
barplot(iris$Species) # no le deja, no hay info matemática para calcular las frecuencias
datosLocos<-table(iris$Species)  # cojemos las frecuencas de la table
barplot(datosLocos, main="BARRACAS", xlab="ESPECIES DE PETALACOS", ylab = "NUMERACOS", col = c("red","blue","green"),
        legend.text = c("Setosa", "Versicolor", "Virginica"), ylim= c(0,60), xlim=c(0,5), las=1, font.axis=6) #barploteamos esa variable y headshot!

barplot(datosLocos, horiz = TRUE)
help(par)
pie(datosLocos)

barplot(table(cadena))
