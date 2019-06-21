# 1. Se ha realizado un estudio genético poblacional en 100 individuos y se ha comprobado que la frecuencia de la presencia del 
# alelo TH01 (marcador STR) es del 25%. Podemos suponer hay independencia en la presencia del alelo entre los individuos de la población.
# Se pide:
#   a) Calcula media y la desviación típica de esta distribución.

n<-100
p<-0.25
exA_binomialMean <- n*p
exA_standarDeviation <- (1-2*p)/(sqrt(n*p*(1-p)))
exA_binomialMean
exA_standarDeviation

# b) Calcula la probabilidad de que haya 28 individuos que presenten el alelo TH01.

dbinom(28, size=100, prob=0.25)

# c) Calcula la probabilidad de que haya, como máximo, 30 individuos que presenten el alelo TH01.

pbinom(38, size=100, prob=0.25)

# d) Calcula la probabilidad de que al menos 15 individuos presenten el alelo TH01.

1- pbinom(15, 100, 0.25)

# e) Calcula la probabilidad de que haya entre 20 y 40 individuos que presenten el alelo TH01.

sum(dbinom(20:40, 100, 0.25))
# es igual a hacer:
pbinom(40,100, 0.25) - pbinom(19, 100, 0.25)

# f) ¿A partir de cuántos individuos representan el 80% de la población con presencia del alelo TH01?

qbinom(0.8, 100, 0.25)

# g) Calcula la mediana de esta distribución.

qbinom(0.5, 100, 0.25) # la mediana es igual al segundo quartil o percentil 5

# i) Genera 10000 valores aleatorios de esta distribución, con semilla 123456, y haz un gráfico adecuado para representarlos. 

set.seed(123456)
freqAbs <- table(rbinom(10000, 100, 0.25))
freqRel <- prop.table(freqAbs)
par(mfrow=c(1,2))
plot(freqAbs, main="Distribución del alelo TH01 en frecuencias absolutas", type="l", 
     xlab="Cantidad de inviduos sobre 100\n con el alelo TH01", ylab="frecuencias relativas", col="red")
plot(freqRel, main="Distribución del alelo TH01 en frecuencias absolutas", type="l", 
     xlab="Cantidad de inviduos sobre 100\n con el alelo TH01", ylab="frecuencias relativas", col="green")
dev.off()


#######################################################################################################################################

# 2. La cantidad de colesterol en sangre en una población sigue una distribución normal de media 200 mg/dl y desviación típica de 20 mg/dl. 
# Se pide
# a) Representa la gráfica de su distribución de probabilidad.

curve(dnorm(x,200,20), xlim=c(110,270), main="Dstribución normal de colesterol en sangre", col="blue", 
      xlab="mg de colesterol por dl en sangre", ylab="Distribución normal", lwd=2)

# b) Calcula la probabilidad de que un individuo tenga 195 mg/dl. de colesterol. 

pnorm(192, 200, 20)

# c) Calcula el porcentaje de individuos que puedan tener el colesterol por debajo de 195 mg/dl.
# Representa en la gráfica el área correspondiente a éste porcentaje.

pnorm(192, 200, 20)

curve(dnorm(x,200,20), xlim=c(110,270), main="Dstribución normal de colesterol en sangre", col="blue", 
      xlab="mg de colesterol por dl en sangre", ylab="Distribución normal", lwd=2)

xs <- c(seq(110,192, length.out=200))
ys <- dnorm(xs,200,20)

polygon(c(110,xs,192), c(0,ys,0), col="blue")

# d) Calcular el porcentaje de individuos que puedan tener el colesterol por encima de 225 mg/dl. 
# Representa en la gráfica el área correspondiente a éste porcentaje. 

1 - pnorm(225, 200, 20)

xs <- c(seq(225,270, length.out = 200))
ys <- dnorm(xs,200,20)

polygon(c(225,xs,270), c(0,ys,0), col="green")

# e) Calcular la probabilidad de que el colesterol de un individuo elegido al azar esté comprendido entre los 190 y los 210 mg/dl.
# Representa en la gráfica el área correspondiente a éste porcentaje.

pnorm(210,200,20) - pnorm(190,200,20)

xs <- c(seq(190,210, length.out = 200))
ys <- dnorm(xs,200,20)

polygon(c(190,xs,210), c(0,ys,0), col="red")

# f) ¿Cuál es el valor de la concentración de colesterol en el cual se sitúa el 90% de la población?  
# Representa en la gráfica el área correspondiente a éste porcentaje de población.

p9<-qnorm(0.9, 200, 20)
xs <- c(seq(110,p9, length.out = 200))
ys <- dnorm(xs,200,20)

polygon(c(110,xs,p9), c(0,ys,0), col="yellow")

# g) Genera 10000 valores de una normal aleatoria, con semilla 123456, que corresponda con los parámetros de la normal de éste problema.
# Representa el histograma de estos valores. Añade al gráfico la curva de densidad de la normal.

set.seed(123456)
valors_random <- rnorm(10000, 200, 20)
hist(valors_random, freq = FALSE, main="Histograma para valores random de colesterol", xlab="Colesterol en sangre",
     ylab="Porcentaje en población", col=sample(colours(), 6))
lines(density(valors_random), col="blue", lwd=2)

# h) Añade a la gráfica anterior un “slider” con un rango de longitudes de intervalos comprendido entre 15 y 35.
library(manipulate)
manipulate(hist(valors_random, breaks=algo, main="Histograma de colesterol con sliver"), algo=slider(15,35))
  
#######################################################################################################################################

# 3. Se está estudiando la relación posible entre la expresión de un gen con la dosis suministrada de cierto medicamento.
# Los datos obtenidos del experimento son:
#   dosis subministrada (variable dosis en miligramos): 
#   38.0, 20.6, 17.5, 30.5, 36.6, 12.5, 12.2, 11.4, 24.7, 24.4, 13.7, 32.8, 14.9, 33.3, 36.8, 14.5, 13.6, 28.6, 28.9, 19.1
# expresión del gen (variable gen en microgramos):
#   11.1, 6.1, 4.5, 8.3, 8.6, 1.7, 2.7, 2.7, 5.9, 8.2, 3.9, 7.4, 2.4, 8.3, 10.5, 4.2, 4.7, 7.5, 8.0, 4.5
# Se pide:
# a) Representa gráficamente la nube de puntos de la expresión génica en función  de la dosis suministrada del medicamento

dosis <- c(38.0, 20.6, 17.5, 30.5, 36.6, 12.5, 12.2, 11.4, 24.7, 24.4, 13.7, 32.8, 14.9, 33.3, 36.8, 14.5, 13.6, 28.6, 28.9, 19.1)
exp_gen <- c(11.1, 6.1, 4.5, 8.3, 8.6, 1.7, 2.7, 2.7, 5.9, 8.2, 3.9, 7.4, 2.4, 8.3, 10.5, 4.2, 4.7, 7.5, 8.0, 4.5)

plot(dosis, exp_gen, main="Expresión génica en función  del medicamento", ylab="Expresión Génica")

# b) ¿Tiene sentido ajustar una recta de regresión a estos datos? ¿Por qué?

cor(dosis, exp_gen)
print("Sí que tiene sentido analizar la recta porque el coeficiente de correlación lineal de Pearson es muy cercano a 1")

# c) Sobre la gráfica de la nube de puntos del gráfico (apartado a) representa la recta de regresión lineal 
# (Y = expresión génica y X = dosis del medicamento).  Añade al gráfico la expresión matemática de la recta obtenida.

rec_ln <- lm(dosis ~ exp_gen)
abline(rec_ln, lwd=2, col="blue")
# en mi sesión de r no printa la recta

# d) Si a un paciente se les suministra una dosis de 22 miligramos de medicamento, ¿cuál será la cantidad esperada de expresión
# génica? Desde el punto que corresponde a la abscisa “x=22”, añade la recta vertical correspondiente al valor de la ordenada de
# la recta en ese punto de la gráfica. Obtén el valor numérico de la ordenada en la abscisa “x=22” (variable “y_22”)
# e) Realiza los 3 primeros apartados, pero ahora con la variable Y = dosis del medicamento y la variable X = expresión génica.
# f) Genera nuevamente las dos gráficas anteriores, (“Y = expresión génica”, “X = dosis del medicamento” y “Y = dosis del medicamento”,
# “X = expresión génica”), con sus rectas de regresión correspondientes. Exporta las 2 gráficas en un único archivo “pdf”
# g) Representa nuevamente la gráfica del apartado a), y calcula su recta de regresión pero sin utilizar la función de R que te da
# el resultado directamente