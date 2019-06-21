# Part A:
condA <- sample(0:20, 7, replace = TRUE)
condB <- sample(0:20, 7, replace = TRUE)
instants <- seq(0, 180, by = 30)
plot(instants, condA, type="b", main="Different expresions of Gen X", xlab= "Time intervals", 
     ylab= "Gene expressions", col="red",xlim=c(0,200),ylim=c(0,20),xaxt="n")
axis(1, seq(0,180,30))
lines (instants, condB, type="b", col="blue")
legend("bottomright", c("Condition A", "Condition B"), col = c("red","blue"), lty=1)

# Part B
datos <- read.delim("/home/bort/Desktop/Table2.txt", header = TRUE, sep = '\t', as.is = TRUE)

#Part C
datesChr <-datos[, grep("Chr", colnames(datos))]
datesGeneStart <-datos[, grep("GeneStart", colnames(datos))]
datesGeneEnd <-datos[, grep("GeneEnd", colnames(datos))]

datesMatrix<- matrix(c(datesChr, datesGeneStart, datesGeneEnd), ncol=3)

datesDataFrame <- data.frame(datesChr, datesGeneStart, datesGeneEnd)

# Part D
kidneys <- datos[, grep("Kidney", colnames(datos))]
livers <- datos[, grep("Liver", colnames(datos))]

dataFrameKidneys <- data.frame(kidneys, livers)

# Part E
tableChr<-table(datesChr)
pie(tableChr, labels = names(datesChr), radius=1.5, main = "Recount of total expressions per chromosome")

# Part F
mides <- c(datos$GeneEnd-datos$GeneStart)
hist(log2(mides))
install.packages("manipulate")
library(manipulate)
manipulate(hist(log2(mides)), bins = slider(1,10, step=1, initial = 5, label="intérvalos"), resetSeed=button("Reset seed"))

# Part G
datesL3Kidney <-datos[, grep("L3Kidney", colnames(datos))]
datesL3Liver <-datos[, grep("L3Liver", colnames(datos))]

mean(datesL3Kidney)
mean(datesL3Liver)

median(datesL3Kidney)
median(datesL3Liver)

quantile(datesL3Kidney)
quantile(datesL3Liver)

quantile(datesL3Kidney, probs=seq(0,1, 0.1))
quantile(datesL3Liver, probs=seq(0,1, 0.1))

var(datesL3Kidney)
var(datesL3Liver)

sd(datesL3Kidney)
sd(datesL3Liver)

IQR(datesL3Kidney)
IQR(datesL3Liver)

range(datesL3Kidney)
range(datesL3Liver)

#Part H
datosKidney<- datos[,grep("Kidney", colnames(datos))]
datosLiver<- datos[,grep("Liver", colnames(datos))]

kidney_mean <- apply(datosKidney, 1, mean)
liver_mean <- apply(datosLiver, 1, mean)

mean(kidney_mean)
mean(liver_mean)

median(kidney_mean)
median(liver_mean)

quantile(kidney_mean)
quantile(liver_mean)

quantile(kidney_mean, probs=seq(0,1, 0.1))
quantile(liver_mean, probs=seq(0,1, 0.1))

var(kidney_mean)
var(liver_mean)

sd(kidney_mean)
sd(liver_mean)

IQR(kidney_mean)
IQR(liver_mean)

#Part I

plot(log2(kidney_mean), main="Comparativa de medias de hígado y riñón")
points(log2(liver_mean), col="red")
legend("topright", c("Riñón", "Hígado"), col = c("black","red"), lty=1)

# Part 

pdf("/home/bort/Desktop/kidney_plots.pdf")

par(mfrow = c(4,2))

boxplot(log2(datos$R1L1Kidney), main = "Expresión génica riñón 1")
boxplot(datos$R2L2Kidney, main = "Expresión génica riñón 2")
boxplot(log2(datos$R1L3Kidney), main = "Expresión génica riñón 3")
boxplot(log2(datos$R2L4Kidney), main = "Expresión génica riñón 4")
boxplot(log2(datos$R2L6Kidney), main = "Expresión génica riñón 6")
boxplot(log2(datos$R1L7Kidney), main = "Expresión génica riñón 7")
boxplot(log2(datos$R2L8Kidney), main = "Expresión génica riñón 8")

dev.off()

pdf("/home/bort/Desktop/liver_plots.pdf")

par(mfrow = c(4,2))

boxplot(log2(datos$R2L1Liver), main = "Expresión génica hígado 1")
boxplot(log2(datos$R1L2Liver), main = "Expresión génica hígado 2")
boxplot(log2(datos$R2L3Liver), main = "Expresión génica hígado 3")
boxplot(log2(datos$R1L4Liver), main = "Expresión génica hígado 4")
boxplot(log2(datos$R1L6Liver), main = "Expresión génica hígado 6")
boxplot(log2(datos$R2L7Liver), main = "Expresión génica hígado 7")
boxplot(log2(datos$R1L8Liver), main = "Expresión génica hígado 8")

dev.off()

par(mfrow = c(1,2))

boxplot(log2(kidney_mean), main="Media de expresión génica del hígado")
boxplot(log2(liver_mean), main = "Media de expresión génica del hígado")

dev.off()

# Part K

dataSd<-c(sd(datos$R1L1Kidney), sd(datos$R1L3Kidney), sd(datos$R1L7Kidney), sd(datos$R2L2Kidney),
          sd(datos$R2L4Kidney), sd(datos$R2L6Kidney), sd(datos$R2L8Kidney))
barplot(dataSd, main = "Desviación estandar de las expresiones génicas para los 7 riñones", 
        col=c("red", "blue", "green", "black", "yellow", "brown", "magenta"))
