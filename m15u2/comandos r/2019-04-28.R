search()
update.packages()
install.packages("sos")
library(sos)

source("http://bioconductor.org/biocLite.R")
biocLite()

biocLite("yeastExpData")
library("yeastExpData")

biocLite("seqinr")
library("seqinr")

getncbiseq <-function(accession) {
  require("seqinr")
  dbs <-c("genbank","refseq","refseqViruses","bacterial")
  numdbs <-length(dbs)
  for(i in 1:numdbs) 
  {
    db <- dbs[i]
    choosebank(db)
    resquery <-try(query(".tmpquery",paste("AC=", accession)), silent =TRUE)
    if(!(inherits(resquery, "try-error"))) 
    {
      queryname <- "query2"
      thequery <-paste("AC=",accession,sep="")
      query2<-query(`queryname`,`thequery`)
      seq <- getSequence(query2$req[[1]])
      closebank()
      return(seq)
    }
    closebank()
  }
  print(paste("ERROR: accession",accession,"was not found"))
}

dengueseq <- getncbiseq("NC_001477")

#mirar la longitud
length(dengueseq)
#hacer un table. Podemos hacer un barplot con ello 
table(dengueseq)
