################ Rectas de regresión ################

# cojemos dos vectores de misma longitud que pensamos que tienen alguna relación
edad <- c(56, 42, 72, 36, 63, 47, 55, 47, 38, 42)
length(presion)
presion <- c(148,126,159,118,149,130,151,142,114,141)

plot(presion,edad)

reg_ln <- lm(edad ~ presion)
reg_ln

# y = a.x + b >>>>>> a = 0.67  //  b = -43.54

summary(reg_ln)

# coeficiente de correlación lineal de Pearson: es el coeficiente que nos permite controlar la calidad de esa regresión lineal, 
# si de entrada puede ser buena o no

cor(edad, presion)

# la función abline solo encesita que le pasemos el coeficiente y el corte del eje 
# de las y para trazar la recta de regresión simple
abline(reg_ln)

# Queremos saber si 2 variables tienen relación entre ellos
# Intentamos ver si tienen alguna relación lineal (proporcionalidad)
# Porque es la relación matemática más sencilla
# Ejemplo: Peso / Altura    Posibilidades: experimentos
# Caso 1: todo se ajusta a una recta: significa que es una ley, que conociendo un peso podemos conocer su altura y viceversa
# (ejemplo real: ley de Ohm)
# Caso 2: si se ajusta todo a una circunsferencia -- ninguna relación lineal

# OBJETIVO: explicar el comportamiento de una variable controlada, siempre queremos encontrar la función lineal
# que mejor se ajuste a (o explique) las 2 variables
# la recta de regresión se obtiene por el método de mínimos cuadrados, es decir, midiendo
# la distancie entre el punto experimental y su distanci a la recta (distancia en y)
# Aquí hay una explicación teórica de cómo obtener la recta de regresión que no pienso copiar
# resumen:
# y = ab + x
# b = (media de y) - a.(media de x)
# a = Sxy/S²x =  (covarianza xy) / (varianza de la x)   (La covarianza es la varianza pero de dos valores a la vez)
#
# el coefiiciente de pearson es r = Sxy/Sx.Sy, es devir, la desviación típica de xy dividida por el producto
# de la desviación estandar de x y de y
# Sxy = 1/n . (sum(xi-media de x)(yi-media de y))


# respuesta
mean(presion)
mean(edad)
covarianza <- (sum((presion-mean(presion))*(edad-mean(edad))))/(length(presion)-1)
desviacionX <- var(presion)
a <-covarianza/desviacionX
b <- mean(edad)-a*mean(presion)
b

# Ejercicio: calcular la correlación entre la longitud del sepálo y su ancho, y lo mismo para el pétalo
cor(iris$Sepal.Length, iris$Sepal.Width)
cor(iris$Petal.Length, iris$Petal.Width)
cor(iris[1:4])

plot(iris$Petal.Length, iris$Petal.Width)
regresion<- lm(iris$Petal.Width ~ iris$Petal.Length) # ojo: esto devuelve: b y luego a
summary(regresion)
abline(regresion) # a abline hay que pasarle primero b y luego a, sino no printa
dev.off()

?pairs(iris)
