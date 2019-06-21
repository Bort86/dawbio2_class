# ejemplo de función
secuencia <- c("A", "T", "A", "C", "C", "T", "G", "G", "G")
secuencia

GC_percent<-function(x) {
  GC <-0
  for (n in x) {
    if (n == "G") GC <- GC + 1
    if (n == "C") GC <- GC + 1
  }
  return ((GC/(length(x)))*100)
}

# moda
vec <- c(1,1,1,0,0,3,3,3,3,2,2,2,2,2)

table(vec) # ordena pero nos da todos los valores, no la moda

max(table(vec)) # nos devuelve la frecuencia de la moda, pero no su valor

which(table(vec)==max(table(vec))) # devuelve el valor y su posición en el vector, pero no su frecuencia

names(which(table(vec)==max(table(vec)))) # devuelve la moda

# moda del sepal.length

names(which(table(iris$Sepal.Length) == max(table(iris$Sepal.Length))))

# funcion para la moda my_mode
my_mode <- function(x){
  tabla <- table(x)
  valor <- which(tabla==max(tabla))
  result <- names(valor)
  # result <- names(which(table(x)==max(table(x))))
  return (result)
}

my_mode(vec)

# Transformar una variable numérica a categoría
set.seed(12345)
altura <- rnorm(2000, 165, 25) # ojo, son cuantitativas continuas
barplot(altura) # no se usa, altura es discreta, no continua
table(altura)
hist(altura)

#intentar discretizar una variable continua
altura_ent <- round(altura,0)
table(altura_ent)
barplot(altura_ent)
barplot(table(altura_ent))
hist(altura_ent)

# recategorizamos:
# muy bajo < 150
# 150 <= bajo < 160
# 160 <= medio < 170
# 170 <= alto < 185
# 185 <= muy alto

altura>185 #devuelve un boleano para cada posición
altura[altura>185] #devuelve los valores del vector que cumplan esta condición
altura[altura>185 & altura <187]

altura.cat <- altura
altura.cat[altura<150] <- "muy bajo"  # reasignamos el valor asignado a las posiciones que pasamos en la condicion
altura.cat

altura.cat[altura>=150 & altura<160] <- "bajo"
altura.cat[altura>=160 & altura<170] <- "medio"
altura.cat[altura>=170 & altura<185] <- "alto"
altura.cat[altura>=185] <- "muy alto"
table(altura.cat)
barplot(table(altura.cat))

altura.cat<-factor(altura.cat)
table(altura.cat)
levels(altura.cat) # devuelve los nombres de los factores
labels(altura.cat) # índices de las posiciones
names(altura.cat)

# al definir el factor, tmb podemos especificar el orden de los factores (sort)
altura.cat <- factor(altura.cat, levels = c("muy bajo", "bajo", "medio", "alto", "muy alto"))
levels(altura.cat)
table(altura.cat)
barplot(table(altura.cat))
# as.numeric(altura.cat)  // para volver de factor a número

## Binomial
# Es una variable aleatoria discreta
# Se utiliza en experimentos aleatorios en los cuales solo se pueden darse 2 casos : éxito y fracaso. 
# (cara y cruz, sano y enfermo, ser del grupo 0 de sangre o no)

# prob(éxito) + prob(fracaso)= p + q = 1
# Si el experimento lo hacemos n veces, ya tenemos una binomial
# Ejemplo:
# p(p) = 0.4    //  p(q) = 0.6
# probabilidad de que pase p 2 veces de 5 intentos  /// insertar objeto -> formula matemática
# X ~ B(5,0.4)
# mirar en wikipedia
# factorial es x*(x-1)*(x-2)*..*1
dbinom(2, 5, 0.4)
choose (5,2)  # es calcular el factorial de 5 sobre 2
choose (5,2) * 0.4^2 * 0.6^3
