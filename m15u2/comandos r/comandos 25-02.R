dev.off()
a <- 1
b <- "Hola"
sexo <- TRUE
Z <- -1i
real <- 1.3
mode(a)
length(a)
mode(real)
mode(b)
length(b)
mode(Z)
length(Z)
typeof(a)
class(a)
storage.mode(a)
object.size(a)
attributes(a)

x<- vector()
x<- vector(length = 10)
x
vector("integer", length = 10)
x<- 1:6
x
mode(x)
typeof(x)
class(x)
object.size(x)
vector1 <-c(1,8,3,5)
vector2 <-c(T,F,T,T,F)
vector3 <- c("barcelona", "hospi")
vector4 <- c(2+0i, 2+4i)
mode(vector1)
vector1[1:3]
vector1[vector1>4]
vector2>4
vector5<-c("Angel", "Pablo", "Pedro")
vector3<- c(vector3, vector5)
vector3
vector6 <- c(1,8,NA,3,5)
is.na(vector6)
mean(vector6, na.rm = TRUE)
series <- 1:10
series
seq(0,1, length=10)
seq(0,1, length=11)
rep(1:4,2)
rep(1:4, each=2, len=4)
rep(1:4, times=4:1)
mi.iris<-iris
mi.iris
?data
?iris
especies <- mi.iris$Species
especies
esp <- as.character(especies)
esp
table(especies)
lon_pet <- mi.iris$Petal.Length
lon_pet
summary(lon_pet)
lon_pet[4]
lon_pet[4:23]
lon_pet[lon_pet>4]
lon_pet[lon_pet<=1.4]
sort(lon_pet)
mi.iris
area<-mi.iris$Petal.Length*mi.iris$Petal.Width
area
mi.iris<-iris
mi.iris
area <- mi.iris$Petal.Length*mi.iris$Petal.Width
area
mi.iris$Petal.Area<-area
mi.iris$Petal.Area
x_l <- c(T,T,F,F)
typeof(x_l)
x_i <- c(1L, 2L, 3L, 0L)
x_n <- c(25,72.3,0.4)
x_c <- c("Chr1", "Chr2","Chr3","Chr4")
x_m<- c(25, 1L, TRUE, "Chr1")
typeof(x_m)
