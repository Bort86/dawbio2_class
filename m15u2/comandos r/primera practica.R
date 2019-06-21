valors_x<-seq(0,1,by=0.01)
homocigoticos_AA<-valors_x^2
homocigoticos_AA
?plot
#punto2
plot(valors_x, homocigoticos_AA, type="l", col="red", main="Equilibrio Hardy−Weinberg", 
     xlab="frecuencia de A: p", ylab="frecuencia de AA:p²", sub="Individuos normales",
     cex.main=1.5, cex.sub=1.1, cex.lab=.8, xlim=c(0,1), ylim=c(0,1), axes = T, bty="o",
     tcl = -0.5, las=0)
help("points")
colors()
#Funciones de bajo nivel
title(main="Ley de Hardy-Weinberg", col.main="red", font.main=80, cex.main=1.5)
box(lty='1255', col = 'green')agrega color al recuadro de los ejes
abline(v=(seq(0,1,0.1)), col="salmon4", lty="dotted")
abline(h=(seq(0,1,0.1)), col="salmon4", lty="dotted")
text(.92,.5,"normales", cex=0.6)
legend(0.4,1, legend=c("AA:p²"), col=c("red"), lty=1, cex=0.6, lwd=2, fill="red")
legend("center", legend=c("AA:p²"), col=c("red"), lty=1, cex=0.6, lwd=2, fill="red")
axis(4)
rug(seq(0,1,0.5))
dev.off()
par(bg="wheat4", mar=c(0,1,0,1))
plot(valors_x, homocigoticos_AA, type="l")
mtext("p", side=1, line=1, at=-0.1, cex=0.9, font=3, col="black")
mtext("p²", line=0.5, at=-0.1, cex=0.9, font=3, col="black")
mtext(0:1, side=1, las=1, at=-2:2, line=0.3, col="black", cex=0.9, font=2)
mtext(0:1, side=2, las=1, at=-2:2, line=0.5, col="black", cex=0.9, font=2)
#punto3
homocigoticos_aa<-(1-valors_x)^2
plot(valors_x, homocigoticos_aa, type="l", col="green", xlab="frencuencia de A", ylab="frencuencia de aa")
#punto 4
heterocigoticos_Aa<-2*sqrt(homocigoticos_AA)*sqrt(homocigoticos_aa)
plot(valors_x, heterocigoticos_Aa, type="l", col="blue", xlab="frecuencia de A", ylab="frecuencia de Aa")
#punto5
plot(valors_x, homocigoticos_AA, type="l", col="red", main="Equilibrio Hardy−Weinberg", 
     xlab="frecuencia de A: p", ylab="frecuencia de AA:p², aa:q² y Aa:2pq", sub="Individuos normales",
     cex.main=1.5, cex.sub=1.1, cex.lab=.8, xlim=c(0,1), ylim=c(0,1), axes = T, bty="o",
     tcl = -0.5, las=0)
lines(valors_x, homocigoticos_aa, type="l", col="green")
lines(valors_x, heterocigoticos_Aa, type="l", col="blue")
dev.off()
legend(0.4,1, legend=c("AA:p²", "aa:q²", "Aa:2pq"), col=c("red", "green", "blue"), lty=1, cex=0.5, lwd=0.5, fill=c("red", "green", "blue"))
#legend(0.4,0.8, legend=c("aa:q²"), col=c("green"), lty=1, cex=0.6, lwd=2, fill="green")
#legend(0.6,1, legend=c("Aa:2pq"), col=c("blue"), lty=1, cex=0.6, lwd=2, fill="blue")
#punto6
par(mfrow=c(2,2))
plot(valors_x, homocigoticos_AA, type="l", col="red", main="Equilibrio Hardy−Weinberg", 
     xlab="frecuencia de A: p", ylab="frecuencia de AA:p²", sub="Individuos normales",
     cex.main=1.5, cex.sub=1.1, cex.lab=.8, xlim=c(0,1), ylim=c(0,1), axes = T, bty="o",
     tcl = -0.5, las=0)
plot(valors_x, homocigoticos_aa, type="l", col="green", xlab="frencuencia de A", ylab="frencuencia de aa")
plot(valors_x, heterocigoticos_Aa, type="l", col="blue", xlab="frecuencia de A", ylab="frecuencia de Aa")
plot(valors_x, homocigoticos_AA, type="l", col="red", main="Equilibrio Hardy−Weinberg", 
     xlab="frecuencia de A: p", ylab="frecuencia de AA:p², aa:q² y Aa:2pq", sub="Individuos normales",
     cex.main=1.5, cex.sub=1.1, cex.lab=.8, xlim=c(0,1), ylim=c(0,1), axes = T, bty="o",
     tcl = -0.5, las=0)
lines(valors_x, homocigoticos_aa, type="l", col="green")
lines(valors_x, heterocigoticos_Aa, type="l", col="blue")
legend(locator(1), legend=c("AA:p²", "aa:q²", "Aa:2pq"), col=c("red", "green", "blue"), lty=1, cex=0.5, lwd=0.5, fill=c("red", "green", "blue"))
?legend
abline(v="0.01",col="orange",lty="dotted")#hace lineas verticales con lineas punteadas, lty->tipo de linea
abline(v="0.85",col="orange",lty="dotted")#hace lineas verticales con lineas punteadas, lty->tipo de linea

points(valors_x <- 0.01, valors_x^2,col="darkred")
points(valors_x <- 0.01, (1-valors_x)^2,col="darkgreen")
points(valors_x <- 0.01, (2*valors_x)*(1-valors_x),col="blue")

points(valors_x <- 0.85, valors_x^2,col="darkred")
points(valors_x <- 0.85, (1-valors_x)^2,col="darkgreen")
points(valors_x <- 0.85, (2*valors_x)*(1-valors_x),col="blue")
