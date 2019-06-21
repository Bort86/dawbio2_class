getwd()
exons_21 <- read.table("/home/bort/hgTables")
long_exons <- exons_21[,3]-exons_21[,2]
length(long_exons)
max(long_exons)
min(long_exons)
mean(long_exons)
median(long_exons)
quantile(long_exons)
?quantile
quantile(long_exons, prob=seq(0,1, length = 11))
IQR<-quantile(long_exons, c(.75)) - quantile(long_exons, c(.25))
IQR(long_exons)
var(long_exons)
sd(long_exons)
cv<-sd(long_exons)/mean(long_exons)
table(long_exons)
str(long_exons)
summary(long_exons)
boxplot(long_exons)
boxplot(long_exons, ylim=c(0,300))
##################################    vectores    ############################################
vector1 <- c(1,2,3,4,5,6)
write(vector1, "file.txt")
vector2 <- scan("file.txt", integer())
vector2
fruta <- c(3.5, 1.2, 2.5, 3)
names(fruta)<-c("naranja", "pera", "manzana", "platano")
names
x <- 2
print(x)
x
#################################   matrices      #####################################################
vector_matriz<- rep("a", 30)
is.matrix(vector_matriz)
is.vector(vector_matriz)
class(vector_matriz)
dim(vector_matriz) <-c(6,5)   #la función dim espera valores seguidos, por eso usamos concatenar
vector_matriz
vector_matriz2 <- 1:20
dim(vector_matriz2)<- c(4,5)
vector_matriz2
matriz2<- matrix(1:20, nrow=5, ncol=4)
matriz2
dim(matriz2)
?matrix
matriz2<- matrix(1:20, nrow=5, ncol=4, byrow=TRUE)
rownames(matriz2) <-c("uno", "dos", "tres", "cuatro", "cinco")
colnames(matriz2) <-c("A", "B", "C", "D")
matriz2
rownames(matriz2)
colnames(matriz2)
is.matrix(matriz2)
matriz2[2,4]
matriz2[8]  #ojo, cuenta por columnas, aunque lo rellenemos por filas
matriz2[2,] #coje toda la fila 2
matriz2[,2]
is.numeric(matriz2[2,4])
is.matrix(matriz2[2,4])
is.vector(matriz2[2,4])
is.matrix(matriz2[2,])
matriz2["uno",] #si las filas o columnas están definidas con nombres, se pueden invocar por ellos
matriz2[,"A"]
matriz2[,]
matriz3<- rbind(c(1,2,3), c(10,11,12)) #no solo añade filas a una matriz existente, 
                                       #sino que puede crear la estructura de la fila y esa estructura
                                       # la podemos añadir a una matriz
matriz3
matriz3 <- cbind(c(4,5,6,7), c(8,9,10,11))
matriz3
is.matrix(matriz3)
matriz5 <- matrix(1:15, nrow=5, ncol=3)
matriz5
matriz6 <- rbind(1:3, 3:1, c(1,1,1), c(2,2,2), c(3,3,3))
matriz6
matriz5+matriz6
matriz5-matriz6
matriz5*matriz6 #esto solo multiplica valores, para multiplicar en r es %*%
#############################     apply       #######################################
datos<- rbind(c(42,65,174), c(43,70,180), c(47,72,173))
datos <- matrix(c(42,65,174,43,70,180,47,72,173), nrow=3, ncol=3, byrow=TRUE)
rownames(datos) <- c("angel", "pablo", "pedro")
colnames(datos) <-c("edad", "peso", "altura")
datos
apply(datos, 1, mean) # el primer argumento es la matriz; la segunda (al ser matrix) es fila o columna; la tercera es la función
apply(datos, 2, mean)
apply(datos, 2, median)
apply(datos, 2, quantile)
apply(datos, 2, var)
apply(datos, 2, sd)
#############################     array       #######################################
#es una matriz con más dimensiones
dades1 <- array(1:30, dim = c(3,5,2))
dades1