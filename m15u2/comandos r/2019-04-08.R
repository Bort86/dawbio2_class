# Secuencia de adn de 100 n
# p(A)=0.14
# ¿Cuál es la probabilidad de observar 20 As en la secuencia?
# X ~ B(n,p)
# p(x=k)=(nk) * p^k * q^n-k

# p(20)=(100!20!) * 0.14^20 * 0.86^80
calcular <- choose(100,100) * 0.14^20 * 0.86^80
calcular

# calculamos con binom
dbinom(15, size=100, prob=0.14)

# calculamos la función de distribución de propbabilidad, o función de masa de probabilidad

mysequence_x <- seq(0,100,1)
mysequence_y <- dbinom(mysequence_x, size=100, prob=0.14)
plot(mysequence_x, mysequence_y, type="h", col="red", lwd=1.5, xlab="Amount of As", ylab="p(x)")

# Escoge de la gráfica  valores de x, y calcula su probabilidad
# valor de x de maxima probabilidad
which.max(dbinom(0:100, 100, 0.14))-1    # restamos 1 porque r cuenta vectores desde 1, y nuestro primer valor es 0

# mínimo
which.min(dbinom(0:100, 100, 0.14))-1

# prob de un valor concreto === p( x = k )
# prob, de como mínimo, un valor ==== p(x >= k)   >>>>>>> 1 - pbinom(x<=k)
# prob, de como máximo, un valor ==== p(x <= k)   >>>>>>> pbinom(x<=k)

#  Cuál es la probabilidad de tener secuencias de hasta 15 adeninas?
pbinom(15,100,0.14)

# Cuál es la probabilidad de tener como mínimo 28 a?
1-pbinom(27,100,0.14) # es igual a 
sum(dbinom(28:100,100,0.14))
system.time({1-pbinom(27,100,0.14)})
system.time({sum(dbinom(28:100,100,0.14))})

# Responder a la misma pregunta haciendo simulación con 100.000 resultados
adeninas<-rbinom(100000,100,0.14)
#freqAbs<- table(adeninas)
#freqRel<-  table(adeninas)/100000 
summary(adeninas>=28)

# probabilidad de tener secuencias de entre 12 y 20 secuencias
pbinom(20,100,0.14) - pbinom(11,100,0.14)  # es igual a 
sum(dbinom(12:20,100,0.14))

# probabilidad de más de 8
sum(dbinom(9:100, 100, 0.14))
# la media es n*p
100*0.14

# Ver Distribución Normal
# el tratamiento que hace r con las funciones de la distribución normal es "bastante" similar a las de la Binomial
# rbinom > rnorm
# y así
