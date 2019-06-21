library(limma)
library(GEOquery)
library(Biobase)
library(ggdendro)
library(annotate)
library(EnhancedVolcano)
library(tidyverse)
library(reshape2)

devtools::install_github("rstudio/shiny")
geo<- getGEO("GDS858", AnnotGPL = FALSE, destdir = ".")
matriz<- GDS2eSet(geo, do.log2=TRUE)

sample <- sampleNames(matriz)
y <- exprs(matriz)
facLevel<- pData(matriz)[,2]
g<- melt(y, varnames = c( "probe", "sample"))
g$facLevel <- facLevel[match(g$sample, sample)]
gen <- fData(matriz)[,3]
probenames<-rownames(matriz)
g$gen <- gen[match(g$probe, probenames)]


plot<-g %>% filter(gen=="SPTBN1")
ggplot(plot, aes(x=facLevel, y=value)) + geom_jitter(aes(colour=facLevel)) +
  theme(legend.position = "none")


# Cluster
clust.euclid.average <- hclust(dist(t(exprs(matriz)), method))
plot(clust.euclid.average, hang=-1)

ggdendrogram(clust.euclid.average, rotate = TRUE, theme_dendro = FALSE) +
  theme(axis.title= element_blank())



design <- model.matrix(~pData(matriz)[,2])
fit <- lmFit(exprs(matriz), design)
class(ebayes) <- eBayes(fit)
tab <- topTable(ebayes, coef=1, n=1000)
labCol <- as.character(pData(matriz)[,2])
heatmap(exprs(matriz)[rownames(tab),], labCol=labCol)

volcanoplot()


y<- exprs(matriz)
g<- y["200027_at",]
group <- facLevel()
dt <- data.frame("Index"=group, "Expr"=g)
ggplot(dt, aes(x=group, y=Expr)) + geom_jitter(aes(colour=group)) +
  theme(legend.position = "none")

contrast <- function(x){
  x <- make.names(x)
  num <- 1
  gro <- as.character(x)
  vec <- unique(gro)
  cont <- length(vec)
  h <- ""
  v <- vector()
  m <- vector()
  
  for (i in 1:cont){
    v[i] <- vec[i]
  }
  
  for (i in 1:cont){
    for (j in cont:i){
      if(v[i] != v[j]){
        h <- paste(v[i],v[j], sep = "-")
        m[num] <- h
        num <- num+1
      }
    }
  }
  m
}

g <- contrast(facLevel)
geneID <- rownames(tab)
a
