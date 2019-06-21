# Ejemplo de como dibujar polígonos
x <- seq(1,4,0.01)
y <- x^2

# polygon(coordenadas de x, coordenadas de y)
# polygon(c(a1,a2,a3,a4), c(b1,b2,b3,b4))
plot(x, y, cex=0.7, type="l")
polygon(c(2,3,3,2), c(5,5,10,10), col="blue")
polygon(c(2,3,3,2), c(5,5,10,10), density=12)

# ejemplo en una normal

curve(dnorm(x,106,8), xlim=c(80,132), col="blue", lwd=2)

xs <- c(seq(80,120, length.out = 200))
ys <- dnorm(xs,106,8)

polygon(c(80,xs,120), c(0,ys,0), col="blue") # la segunda coordenada son dos vectores, así logramos
