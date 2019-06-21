
# Ejerccio de Binomial
# Sea una secuencia de ADN de 100  nucleótidos. 
# La probabilidad de A en una secuencia es p = 0,14
# ¿Cual es la probabilidad de observar 20 "A" s en la secuencia de ADN?
# 1 Manual
choose(100,20)*0.14^20*0.86^80
# 2 Con R 
dbinom(20, size = 100, prob = 0.14)


# Gráfica de la distribución de probabilidad (función de masa de probabilidad)
# de probabilidad de A en la secuencia (probabilidad de A 0,14)

mysequence_x <- seq(0,100,1)
mysequence_y <- dbinom(mysequence_x,size=100,prob=0.14)
plot(mysequence_x, mysequence_y, type="h", col="red", lwd=1.5, 
     xlab = "Number of As", ylab = "p(x)") 

# Escoge de la grafica 3 valores de x, y calcula la probilidad:
# el valor de x de máxima probabilidad
# dos valores de prob. próxima a cero, uno de la izqueirda y otro de la derecha de la gráfica


dbinom(0:100, size = 100, prob = 0.14)
max(dbinom(0:100, size = 100, prob = 0.14))
which.max(dbinom(0:100, size = 100, prob = 0.14))
which.min(dbinom(0:100, size = 100, prob = 0.14))
dbinom(15, size = 100, prob = 0.14)
dbinom(0, size = 100, prob = 0.14)
dbinom(80, size = 100, prob = 0.14)
dbinom(100, size = 100, prob = 0.14)

# ¿Cual es la probabilidad de tener secuencias de hasta 15 adeninas?
pbinom(15, size = 100, prob = 0.14) 

# ¿Cual es la probabilidad de tener secuencais con al menos 28 adeninas?
1- pbinom(27, size = 100, prob = 0.14) 

# Responde a la misma pregunta haciendo simulación
# Simular un gran número (p. ej., 100.000) secuencias de longitud n = 100,
# y ver en qué fracción de esas secuencias vemos 28 o más como.

adeninas<- rbinom(100000, 100, 0.14)
adeninas >= 28
summary(adeninas >= 28)
22/100000

# En mi caso sale 22/100000 de las secuencias simuladas tienen 28 o más 
# Podemos estimar que la probabilidad de observar al menos 28 
# es 0.00022, que esbastante similar al valor correcto de 0,0001954555 calculado con pbinom

# ¿Cual es la probabilidad de tener secuencias de 12 a 20 adeninas?
# ¿Cual es la probabilidad de tener secuencias de 23 a 5 adeninas?
pbinom(20,100,0.14) -pbinom(15,100,0.14) 

pbinom(23,100,0.14) -pbinom(5,100,0.14) 

# ¿Cual es la probabilidad de tener secuencais mas de 8 adeninas?
1- pbinom(8, size = 100, prob = 0.14) 


##################################

# Probability Density function 
x <- seq(-5, 15, length.out = 200)
y1 <- dnorm(x, mean = 0, sd = 1) 
y2 <- dnorm(x, mean = 8, sd = 0.5)

plot(x = x, y = y1, type = "l", lwd = 2, col = "black", ylim = c(0, 1), xlab = "X", ylab = "Density", yaxs = "i") # the last parameter forces the x-axes to meet the y-axes at 0
lines(x = x, y = y2, lwd = 2, col = "blue")
# rnorm() - genera una distribucion normal al azar
mean <- 8
sd <- 0.5

x.sample <- rnorm(n = 5000, mean = mean, sd = sd) 
z.sample <- (x.sample - mean) / sd 

hist(x.sample, freq = F, ylim = c(0, 1), xlim = c(-5, 15), col = rgb(0,0,1,0.3), yaxs = "i")
hist(z.sample, freq = F, add = T)
# Añadimos fuciones de densidad a los histogramas

lines(x = x, y = y1, type = "l", lwd = 3) 
lines(x = x, y = y2, lwd = 3, col = "blue")

# Funcion de distribución acumulada

z <- seq(-4, 4, 0.01)
cdf <- pnorm(z, 0, 1)

plot(z, cdf, col = "blue", xlab = "z", 
     ylab = "Probabilidad acumulada", type = "l", lwd = 3, cex = 2,
     main = "Fucncion de distribución acumulada", cex.axis = .8, yaxs = "i")
 






El nivel de hemoglobina en hombres sigue una distribución normal 
de media 15.5g/dL y desviación  típica 1.25g/dL. 
El nivel de hemoglobina en mujeres sigue una distribución normal 
de media 14g/dL.
Se sabe además que el 90% de las mujeres tienen un 
nivel de hemoglobina superior a 12.7g/dL.
Calcula:
a)El  porcentaje de hombres con un nivelde hemoglobina entre13.8g/dL y 16g/dL.
56.85%
b)El porcentaje de mujeres con un nivel de hemoglobina inferior a 15.75g/dL.
95.72%
c)El60% de los habitantes de una población son mujeres. 
Si se elige una persona al azar, 
¿cuál es la probabilidad de que su nivel de hemoglobina sea inferior a 14g/dL? 
  0.346

#######################



# Listado de todas las distribuciones incluidas en el paquete 'stats', 
?Distributions
# Distibución Normal o Gaussiana


#Distribuciones en R
# Normal
# dnorm(x, mean = 0, sd = 1) Función de Densidad de Probabilidad, f(x)
# pnorm(q, mean = 0, sd = 1) Función de Distribución de Probabilidad (probabilidad acumulada)
# qnorm(p, mean = 0, sd = 1)  Función de Cuantiles. Dado un valor de x calcula la probabilidad acumulada a izquierda.
# rnorm(n, mean = 0, sd = 1) genera pseudoaleatorios de una normal


# Ayuda de R de las cuatro funciones
?Normal
?dnorm
?pnorm
?qnorm
?rnorm

#################### 1. rnorm ############################

# 1. rnorm(n, mean = 0, sd = 1) genera pseudoaleatorios de una normal
rnorm(200, mean = 0, sd = 1)
hist(rnorm(200, mean = 0, sd = 1))

rnorm(20000, mean = 0, sd = 1)
hist(rnorm(20000, mean = 0, sd = 1))

# Simulacion de las alturas de una poblacion. mean = 165, sd = 15

hist(rnorm(20000, mean = 165, sd = 15))


X <- rnorm(20000, mean = 165, sd = 15)
X
hist(X,freq=FALSE,col="green",main="Histograma",
     sub="Datos simulados de una N(170,12)")
lines(density(X),col="red",lwd=2)
curve(dnorm(x,165,15),xlim=c(110,220),col="blue",lwd=2,add=TRUE) # add=TRUE
x
legend("topleft",col=c("blue","red"),
       legend =c("Densidad normal","Estimador de la densidad"),
       lwd=3, bty = "n")



# demo(graphics)


# dnorm 
# Es la función Densidad de Probabilidad (forma de campana)
# Dado un punto el valor de la función de densidad no es su probabilidad

abcisas <- seq(-1, 7, by=0.1)
ordenadas <- dnorm(abcisas, mean=3, sd=1) 
plot(abcisas, ordenadas, type="l")


#################### 2. pnorm ############################
# pnorm 
# Es la función que describe P(Y <= X) (probabilidad de que Y sea
# menor o igual a X, siendo X un cuantil e Y la distribución normal de una Normal
#  Y está entre 0 y 1

# Simulacion de las alturas de una poblacion  (mean = 165, sd = 15)

hist(rnorm(20000, mean = 165, sd = 15))

curve(dnorm(x,165,15),xlim=c(120,220),col="blue",lwd=2,
      xlab="x",ylab="f(x)",main="Función de Densidad N(165,15)")

plot(dnorm(x,165,15),xlim=c(120,220),col="blue",lwd=2,
     xlab="x",ylab="f(x)",main="Función de Densidad N(165,15)")



dnorm(5, mean = 5, sd = 4)
pnorm(c(115, 110), mean = 110, sd = 4)


y<-rnorm(500);           hist(y);           hist(y,5)

curve(dnorm(x,180,18))
dnorm(x,180,18)    
