##### TRABAJANDO CON RNA-SEQUENCE
# RNA-seq es la versión "cara" de los microarrays: son capaces de secuenciar toda la expresión génica del arn target
# ejemplo: table2.txt. 32000 genes sacados del riñón e hígado, 7 muestras y 7 réplicas de cada uno

# lectura de datos
# datos <- read.table("/home/bort/Escritorio/Table2.txt", header = TRUE, sep = "\t")
?read.table
# ojo con header, es necesario informar si es true o false porque de eso dependerá qeu se ponga
# a leer de la primera o de la segunda linea
# sep es el separador
# as.is es para pedirle que no trate de convertir a factores las columnas que sean string
getwd()
datos <- read.delim("/home/bort/Escritorio/Table2.txt", header = TRUE, sep = '\t', as.is = TRUE)
datos

rnaseq <- read.table("/home/bort/Escritorio/Table2.txt", header = TRUE, sep = '\t', as.is = TRUE)
head(rnaseq)
head(rnaseq,20)
class(rnaseq)
typeof(rnaseq)

# Prueba de parámetros de posición o centralización
# Promedio de toda la columna del primer riñón
mean(rnaseq$R1L1Kidney)
mean(rnaseq[,7])
mean(rnaseq[,"R1L1Kidney"])

# Calculamos la media
median(rnaseq$R1L1Kidney)
#Percentil
quantile(rnaseq$R1L1Kidney, probs=seq(0,1, 0.1))
quantile(rnaseq$R1L1Kidney, probs= 0.9)

# varianza
var(rnaseq$R1L1Kidney)

# desviación típica
sd(rnaseq$R1L1Kidney)

# coeficiente de variación
sd(rnaseq$R1L1Kidney)/mean(rnaseq$R1L1Kidney)

#IQR (rango interquartílico)
IQR(rnaseq$R1L1Kidney)

# máximos y mínimos
max(rnaseq$R1L1Kidney)
min(rnaseq$R1L1Kidney)
diff(range(rnaseq$R1L1Kidney))

# rango de los 7 riñones
range(rnaseq[,c(7,9,12,15,17,18,19)])

valor <- rnaseq[,7:14] #ojo, están mezclados después del 7
for (i in valor) {
  print(range(i))
}

# usamos logaritmos para acercar la cantidad del rango de valores  entre los ejes de x e y

log(2^7, base =2)
log(128, base = 2)
2^7.5
log(181.0193, base=2)

getwd()
# gen ORM1, alfa1-glicoproteina ácida, es un marcador tumoral
# creamos el archivo en pdf
pdf("Escritorio/fig_plots.pdf", width = 6*2, height = 6)
# creamos el marco para guardar 2 gráficos:
par(mfrow = c(1,2))

# Plot A
# agrupamos todas las columnas de riñón y de hígado
kidney <- rnaseq[, grep("Kidney", colnames(rnaseq))]
liver <- rnaseq[, grep("Liver", colnames(rnaseq))]
head(kidney)
head(liver)

plot(log2(rowSums(kidney)),
     log2(rowSums(liver)), 
     xlab= "log Kidney",
     ylab = "log Liver",
     main = "Plot A"
     )
abline(a =1, b=1, col="red") # dibujamos una recta


# Extraemos los datos del gen orm1, el del marcador tumoral
orm1 <- subset(rnaseq, ExternalID == "ORM1")
orm1
orm2 <- rnaseq[rnaseq$ExternalID == "ORM1",] # otra manera de obtener lo mismo
orm2

# ahora separamos el hígado y el riñón
orm1_liver <- orm1[, grep("Kidney", colnames(orm1))]
orm1_kidney <- orm1[, grep("Liver", colnames(orm1))]

plot(1:7, log2(orm1_liver), type="o", col=2, 
     xlab = "replicates", ylab="log2(counts)",
     ylim=c(0,20), main = "Plot B")
lines(1:7, log2(orm1_kidney), type="o", col=3)
legend("topright", c("ORM1 Liver", "ORM1 Kidney"), col = c(2,3), lty=1)
# cerramos el pdf
dev.off()

# ejemplo
# generamos una lista aleatoria de 7 números, repetidos 1000 veces, que simularán ser 1000 genes en 7 cromosomas
anot.crom <- sample(1:7, 1000, 
                    prob = c(0.15, 0.25, 0.35, 0.1, 0.1, 0.03, 0.02),
                    replace = TRUE)
anot.crom
# le ponemos nombre a las cabeceras
names(anot.crom) <- paste("gen", 1:100, sep = "_")
head(anot.crom)
table(anot.crom)
barplot(table(anot.crom), main ="Genes agrupados por cromosomas", xlab="Cromosomas", ylab="Genes anotados")

# histograma de la primera réplica del riñon
kidney1 <- rnaseq$R1L1Kidney
kidney1
hist(kidney1) # nos sale todo acumulado en la misma barra por problema de escala
# usamos el log2 mejor

hist(log2(kidney1))

# boxplot
kidney <- rnaseq[, grep("Kidney", colnames(rnaseq))]
liver <- rnaseq[, grep("Liver", colnames(rnaseq))]

boxplot(list("kidney"=log2(rowSums(kidney)+1),
             "liver"=log2(rowSums(liver)+1)),
        col = "purple")
