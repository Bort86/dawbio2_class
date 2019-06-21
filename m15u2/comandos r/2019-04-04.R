############# BINOMIAL #############
# DBINOM = fUNCIÓN PARA CALCULAR LA BINOMIAL

# factorial es x*(x-1)*(x-2)*..*1
dbinom(2, 5, 0.4)
choose (5,2)  # es calcular el factorial de 5 sobre 2
choose (5,2) * 0.4^2 * 0.6^3
# Calculamos p(x=3) con el mismo p de 0.4
dbinom(3, 5, 0,4)
# o 
# choose (n,k=x) * p^k * q^(n-k)
choose(5,3) * 0.4^3 * 0.6 ^2  
dbinom(3, 5, 0,4)

############# FUNCIÓN DE DISTRIBUCIÓN ACUMULADA #############
# PBINOM
# Permite calcular la probabilidad conjunta de todos los valores acumulados hasta un cierto valor
# De cinco hijos, ¿cuál es la probabilidad de tener como máximo 3 hijos varones?
# F(3) = p(x <= 3) = p(x=0) + p(x=1) + p(x=2) + p(x=3)
pbinom(3, 5, 0.4)

############## RBINOM ######################
# siguiendo el caso de las familias: genera 2000 observaciones de familias de 5 hijos con prob de 0.5 de éxito
# es decir, la primera familia, tuvo 2 varones, la segunda 3, la n-1 4, y la n 2
rbinom(2000, 5, 0.5)

# lo guardamos en una variable y hacemos table para ver las frecuencias absolutas
freqAbs <-table(rbinom(2000, 5, 0.5))
freqAbs

# usamos la función prob.table para ver la misma tabla pero normalizada en frecuencias relativas
freqRel <- prop.table(frecAbs)

plot(frecAbs)
plot(freqRel)

# miramos para 20 familias

freqAbs <- table(rbinom(20, 5, 0.5))
freqAbs

freqRel <- prop.table(freqAbs)
freqRel
 
# al ser la muestra más pequeña no se observa tanta simetría como con la muestra de 2000

pdf("/home/bort/Escritorio/m15u2/comandos r/Binomial20.pdf", width = 7, height = 5)
par(mfrow=c(1,2))
plot(freqAbs, main="Binomial para 20 casos")
plot(freqRel, main="Binomial relativa para 20 casos")
dev.off()

# probamos para 20000 familias
freqAbs <-table(rbinom(20000, 5, 0.5))
freqRel <- prop.table(frecAbs)

pdf("/home/bort/Escritorio/m15u2/comandos r/Binomial20.pdf", width = 7, height = 5)
par(mfrow=c(1,2))
plot(freqAbs, main="Binomial para 20000 casos")
plot(freqRel, main="Binomial relativa para 20000 casos")
dev.off()

# Calcular la binomial en rangos
dbinom(0:5, 5, 0.5)
plot(dbinom(0:5, 5, 0.5), type="p")

# Probabilidad acumulada para tener como máximo 2 hijos con prob de 0.4 y n 5
# con pbinom
pbinom(2, 5, 0.4)
# o con dbinom sumado
sum(dbinom(0:2, 5, 0.4))

##################### QBINOM #########################
# Calcula los resultados de los percentiles binomiales
# ¿Cuál es el valor de la probabilidad acumulada (percentil alfa) que deja a la izquierda (o por debajo) un alfa% de los valores?
# Es decir
# p(X<=k)= 0.8 <<<<<< Calcular K
qbinom(0.8, 5, 0.4)

#simulamos
simul1 <- rbinom(200, 5, 0.4) # 200 familias con 5 hijos
mean(simul1)
sd(simul1)

simul1 <- rbinom(200, 5, 0.4) # 20000 familias con 5 hijos
mean(simul1)
sd(simul1)

# percentiles
simul2 <- rbinom(20000, 5, 0.5)
quantile(simul2, prob=seq(0, 1, length= 101)) # para ver los percentiles dividos en 1%

############### EJEMPLO #################   
# frecuencia de daltonismo en la población es del 8%
# p(d)= 0.08
# sigue una binomial 
# lo miramos en una familia de 9 hijos
# media de hijos afectados = 9 * 0.08 = 0.72
# varianza = 9 * 0.08 * 0.92 = 0.6624   n*p*q

# Probabilidad de que ninguno sea daltónico
# p(x=0)
dbinom(0, 9, 0.08)

# probabilidad de que sean 5 daltónicos
dbinom(5, 9, 0.08)

# prob de que al menos 5 sean daltónicos
# 1- p(x <= 4)

1 - pbinom(4, 9, 0.08)

# obtener entre 5 y 7 daltónicos
# y calcula que deja a su derecha el 32% de los valores