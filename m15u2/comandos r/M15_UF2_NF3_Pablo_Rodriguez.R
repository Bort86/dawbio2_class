# 1
# a

datos<-iris[,1:4]

dim(datos) # 150 filas y 4 columnas

# b

cor(datos) # matrix de correlación

cor(datos$Petal.Width, datos$Petal.Length) # el coeficiente de las dos variables con el cor más alto

plot(datos[,c(1,3)]) # plot

# c


plot(x=iris$Petal.Length, y=iris$Petal.Width, xlab="Longitud del petalo en cm", ylab="Ancho del pétalo en cm",
     main="Datos sobre plantas Iris", col=iris$Species, pch=23, sub="Puntos: media (rojo) y mediana (azul)")

abline(v = mean(iris$Petal.Length), h = mean(iris$Petal.Width), col="red", lwd=2, lty=2)
abline(v = median(iris$Petal.Length), h = median(iris$Petal.Width), col="blue", lwd=2, lty=2)

points(x=mean(iris$Petal.Length), y=mean(iris$Petal.Width), pch=23, cex=2, bg="red")
points(x=median(iris$Petal.Length), y=median(iris$Petal.Width), pch=23, cex=2, bg="blue")

legend("topleft",title="Tres especies de Iris", legend=levels(iris$Species), fill =c("black", "red", "green"))

#d

reg_ln <- lm(iris$Petal.Width ~ iris$Petal.Length)
abline(reg_ln)
legend("bottomright", title="Formula", legend=c("y = ab + x", "b = (media de y) - a.(media de x)", "a = Sxy/S²x"),cex=0.6)

# e
salida.lm <- lm(iris$Petal.Width ~ iris$Petal.Length)
class(salida.lm)
summary(salida.lm)
names(salida.lm)
salida.lm$coefficients

# f
plot(x=iris$Petal.Length, y=iris$Petal.Width, xlab="Longitud del petalo en cm", ylab="Ancho del pétalo en cm",
     main="Datos sobre plantas Iris", col=iris$Species, pch=23, sub="Puntos: media (rojo) y mediana (azul)")

abline(v = mean(iris$Petal.Length), h = mean(iris$Petal.Width), col="red", lwd=2, lty=2)
abline(v = median(iris$Petal.Length), h = median(iris$Petal.Width), col="blue", lwd=2, lty=2)

points(x=mean(iris$Petal.Length), y=mean(iris$Petal.Width), pch=23, cex=2, bg="red")
points(x=median(iris$Petal.Length), y=median(iris$Petal.Width), pch=23, cex=2, bg="blue")

legend("topleft",title="Tres especies de Iris", legend=levels(iris$Species), fill =c("black", "red", "green"))

abline(salida.lm$coefficients[1],salida.lm$coefficients[2]) # aqui está la recta
legend("bottomright", title="Formula", legend=c("y = ab + x", "b = (media de y) - a.(media de x)", "a = Sxy/S²x"),cex=0.6)

##################################################

##2
##a

curve(dnorm(x,1.90,0.52), xlim=c(0,4), main="Este es el título", col="blue", xlab="Título de eje x", ylab="Titulo de eje y")

## b
pnorm(1.90,1.90,0.52) #p de media
pnorm(1.90,1.90,0.52) #p de mediana

# c
1-pnorm(2.4,1.9,0.52)

## d
media <- 1.90
desv <- 0.52

pnorm(media+desv, media, desv) - pnorm(media-desv, media, desv)
pnorm(media+2*desv, media, desv) - pnorm(media-2*desv, media, desv)
1 - (pnorm(media+desv, media, desv) - pnorm(media-desv, media, desv))
1 - (pnorm(media+2*desv, media, desv) - pnorm(media-2*desv, media, desv))

# e
curve(dnorm(x,1.90,0.52), xlim=c(0,4), main="Este es el título", xlab="Título de eje x", ylab="Titulo de eje y")
xs<-c(seq(media-desv,media+desv, length.out = 200))
ys<-dnorm(xs, 1.9, 0.52)

polygon(c(media-desv, xs, media+desv), c(0,ys,0), col="red")
# lo mismo para las otras 3 variables pero no me da tiempo a hacerlo

## f
pnorm(1.4, media, desv)

## g
qnorm(0.05,media, desv) # 5% de la poblacion
qnorm(0.95,media, desv) # 95# de la poblacion
qnorm(0.95,media, desv) # dejar afuera al 5% es el 0.95

## h

set.seed(123456)
valors_random <- rnorm(3000, media, desv)
hist(valors_random, freq = FALSE, main="Histograma para valores", xlab="Microgramos",
     ylab="Mml", col=sample(colours(), 6), ylim=c(0,0.9))
lines(density(valors_random), col="blue", lwd=2)

#######################################################

#### 3

# a
mis.datos <- read.table("GSE45263_gene.expression.measurements.txt", header = TRUE, sep="\t")
class(mis.datos)
colnames(mis.datos)
head(mis.datos)
dim(mis.datos) # 25813 filas y 21 columnas

# b
row.names(mis.datos)<-mis.datos[,1]
row.names(mis.datos)
row.names(mis.datos)<-seq(nrow(mis.datos)) # para volver a ponerle los numeros

# c
m_mis.datos <- as.matrix(mis.datos)
colnames(m_mis.datos)
dim(m_mis.datos)

# d
especies<-c(rep("human", 14), rep("chimp", 6))

# e
Human <- mis.datos[,2:15]
Chimpanzee <- mis.datos[,16:19]

#f
boxplot(m_mis.datos[1,2:21] ~ especies, data=m_mis.datos)
length(m_mis.datos[1,2:21])
length(especies)

# g
mean.Human<-rowMeans(Human)
mean.Chimpanzee<-rowMeans(Chimpanzee)

plot(mean.Human[1:15])
plot(mean.Chimpanzee[1:15])

# h

median.Human<-apply(Human, 1, median)
median.Chimpanzee<-apply(Chimpanzee, 1, median)

plot(median.Human[1:15])
plot(median.Chimpanzee[1:15])

# i
par(mfrow=c(2,2))
boxplot(mean.Human, main="mean.Human")
boxplot(mean.Chimpanzee, main="mean.Chimpanzee")
boxplot(median.Human, main="median.Human")
boxplot(median.Chimpanzee, main="median.Chimpanzee")

# j
cor(mean.Human, mean.Chimpanzee)
cor(median.Human, median.Chimpanzee)

plot(mean.Chimpanzee ~ mean.Human)
reg_ln <- lm(mean.Chimpanzee ~ mean.Human)
abline(reg_ln, col="red")

plot(median.Chimpanzee ~ median.Human)
reg_ln <- lm(mean.Chimpanzee ~ mean.Human)
abline(reg_ln, col="red")

# k
par(mfrow=c(2,2))
hist(mean.Human, main="mean.Human")
hist(mean.Chimpanzee, main="mean.Chimpanzee")
hist(median.Human, main="median.Human")
hist(median.Chimpanzee, main="median.Chimpanzee")

#l
Human <- mis.datos[,1:15]
Chimpanzee <- mis.datos[,c(1,16:19)]

helper <- Human[Human$ID_REF=="ENSG00000001167",]

boxplot(helper[,2:ncol(helper)])