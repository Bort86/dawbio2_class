# Ejemplo de como dibujar poligonos
x <- seq(1,4,0.01)
y <- x^2
plot(x,y,cex=0.7, type="l")
polygon(c(2,3,3,2),c(5,5,10,10),col="blue")
polygon(c(2,3,3,2),c(5,5,10,10),density = 12)


# Ejecicio de una normal, para un caso de población diabética

# La glucemia basal de los diabéticos sigue una normal
# con media 106 mg por 100ml, y desviación típica 8 mg por 100 ml N(106, 8). 
# Se pide:
# a) Representa la grafica

valors_x <- seq(80,132,0.01)
valors_y <- dnorm(valors_x, 106, 8)
plot(valors_x, valors_y, type = "l", col = "blue", lwd = 2,
     main="Función de densidad de probabilidad para N(106,8)", 
     xlab="mg glucosa por 100ml", ylab="f(x)")

# b) Simulacion de la glucemia diabeticos de una poblacion  (mean = 106, sd = 8)

valors_random <- rnorm(20000, 106, 8)
hist(valors_random, freq=FALSE, ylim=c(0, 0.06))  # pongo un ylim para que se vea bien hasta arriba la curva que viene abajo
curve(dnorm(x, 106, 8), xlim=c(80,132), add=TRUE)

# c) La proporción de diabéticos con una glucemia basal inferior a 120 mg por100 ml, P(X<120) (recuerda que en variables continuas es lo mismo menor que  menor o igual). 

pnorm(120, 106, 8)

# d) Representa el area en la grafica que refleja la probabilidad P(X=<120) 

# e) La proporción de diabéticos con una glucemia basal comprendida entre 106 y 120 mg por 100 ml.

pnorm(120, 106, 8) - pnorm(106,106,8)
# ojo, pnorm(106,106,8 es 0.5)

# f) Reprenta el area en la grafica que refleja la probabilidad P(106 =<X =<110) 
# g) La proporción de diabéticos con una glucemia basal mayor de 120 mg por100 ml.

1 - pnorm(120,106,8)

# h) Reprenta el area en la grafica que refleja la probabilidad P(X>120) =1-P(X =<120) 

# i) Calcula el nivel de glucemia tal que por debajo de ese nivel esten el 25% de los diabéticos (es decir, el primer cuartil).

qnorm(0.25, 106, 8)

# j) Calcula el nivel de glucemia tal que por debajo de ese nivel esten el 50% de # los diabéticos (es decir, el segundo cuartil).