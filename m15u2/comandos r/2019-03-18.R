############ SEGUIMOS GRÁFICOS ############

#### PIE

bases <- c("A", "T", "C", "G")
cadena <- sample(bases,30, replace=TRUE)
pie(table(cadena))

######### HISTOGRAMAS ######

# Histograma >>>> hist()
#         - variables cuantitativas continuas

# generar alturas aleatoriamente de 1000 personas, con dos decimales tops
alturas <- round(runif(1000, min=150, max=210),2)
alturas
hist(alturas)

?rnorm #random normalized: pide cantidad de datos, la media  la desviación típica
ralturas<-rnorm(10000, mean=165, sd=10)
hist(ralturas)
dev.off()
# dada la naturaleza de las probabilidades, vemos que los valores generados
# no son exactamente iguales a los que les pasamos por parámetro, pero son muy similares
mean(ralturas)
sd(ralturas)
var(ralturas)

summary(ralturas)
sd(ralturas)^2

# editamos para mejorar la visualización
ralturas<-rnorm(10000, mean=165, sd=10)
hist(ralturas, main="ALTURAS RANDOM", xlab="Centímetros", ylab = "Alturas", col = c(colors()[sample(1:657,12)]),
        ylim= c(0,3000), xlim=c(100,250), las=1, font.axis=6)

plot(density(ralturas))
hist(ralturas, freq=FALSE, add=TRUE)
dev.off()

## haremos los resultados reproducibles

set.seed(12345)
rralturas <- rnorm(1000, mean=165, sd=10)
summary(rralturas)

#para analizar frecuencias relativas
hist(rralturas, freq=FALSE, ylim = c(0,0.05))
lines(density(rralturas), col = "red")
curve(dnorm(x, mean = mean(rralturas), sd = sd (rralturas)), from = 130, to = 210, add = TRUE, col = "darkgreen")
legend("topleft", col = c("blue", "red"), legend = c("Densidad teórica", "Estimador de la densidad"), lwd = 2, bty = "n", cex = 0.6)
# lwd = 2 ( grosor de 2 puntos de la linea)
# bty tipo de caja
dev.off()
?dnorm

######## SLIDERS ########

hist(iris$Petal.Length, col= c("lightgreen"), breaks = 30)

# más realista
ralturas<-rnorm(1000, mean=165, sd=10)
hist(ralturas, breaks=10, main="Breaks 10")
hist(ralturas, breaks=5, main="Breaks 5") # hay mucha diferencia entre ambos

# instalamos el paquete para manipular
install.packages("manipulate")
library(manipulate) # require(libreria) devuelve true si se bajó o no, sirve para automatizar
?manipulate

manipulate(hist(rnorm(10000, mean=165, sd=10), breaks = bins),
           bins = slider(1,20, step=1, initial=6, label="intervalos"),
           resetSeed = button("Reset Seed"))

dev.off();

manipulate(
  {if(resetSeed)  #todo lo que está dentro de {} es el primer parámetro de manipulate
    set.seed(sample(1:1000))
    hist(rnorm(1000, mean=165, sd=10), breaks = bins)},
  bins = slider(1,20, step=1, initial=6, label="intervalos"),
  resetSeed = button("Reset Seed")
)

# ejemplo con picker
manipulate(
  curve(dnorm(x, sd=desvio), from = -20, to =20, col= color),
  desvio = slider(1, 10),
  color = picker("green", "red", "blue")
)

# checkbox

x <- rnorm(1e4)
x
 manipulate(
   hist(x, breaks= breaks.number, freq=freq.check),
   breaks.number= slider(10,100),
   freq.check= checkbox(FALSE)
 )
 