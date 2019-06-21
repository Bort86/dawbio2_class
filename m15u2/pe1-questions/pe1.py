# - M15-UF2: (Bio)Python Pe1 (2019-02-04)
# ---------------------------------------------------------------------
# - Nom: Pablo
# - Cognoms: Rodriguez Fraga
# - DNI: X6780502X
# ---------------------------------------------------------------------
# - Enunciat:
#   Escriu el codi necessari per resoldre els problemes en aquest fitxer.
#   Quan acabis, puja'l al Moodle.
#
# - IMPORTANT:
#   Les vostres respostes s'avaluaran executant 'python3 pe1.py'.
#   El fitxer 'experiment.data' estarà al mateix directori que pe1.py.
#   Assegureu-vos que el vostre codi NO dóna cap error abans d'entregar-lo!
# ---------------------------------------------------------------------

# Imports
# ---------------------------------------------------------------------
import re
import random
import json
from Bio import SeqIO
from Bio.SeqRecord import SeqRecord
from collections import Counter


# Problema 1: Conversió (5.0 punts)
# ---------------------------------------------------------------------
# - Llegeix el fitxer "experiment.data" i utilitza SeqIO per
#   guardar-lo en format fasta en un fitxer anomenat "answer1.fasta".
# - No cal que la data surti al fitxer fasta.

#opening the file
with open("experiment.data", "r") as text_file:
    content_str = text_file.read().replace('\n', '')

#deleting empty spaces
reg = r'- '
pat = re.compile(reg)
second_str = re.sub(pat, "", content_str)

#parsing the dna seq
reg2 = r'SEQUENCE:(.*)END'
pat = re.compile(reg2)
final_match = pat.search(second_str)

final_str = final_match.group(1)

#transforming the dna string into a seq, then a seq record
my_seq = Seq(final_str)
simple_seq_r = SeqRecord(my_seq, id="Random_Test_id", description="Very nice seq")

#writing the fasta file
SeqIO.write(simple_seq_r, "answer1.fasta", "fasta")

# Problema 2: Simulació (5.0 punts)
# ---------------------------------------------------------------------
# - Aquest problema consisteix en simular una sèrie de mutacions aleatòries.
# - Llegeix les primeres 90 lletres de la seqüència d'ADN del fitxer "experiment.data".
# - Genera 100 seqüències amb una posició aletòria canviada a una lletra (ATCG) aleatòria.
#   Assegura't que a cada nova seqüència hi ha exactament una lletra canviada sempre.
# - Tradueix cada seqüència a la proteïna corresponent.
#   No busquis Met o Stops. Tradueix tots els aminoàcids.
# - Crea un diccionari del tipus {seq: num}
#   - seq són strings de les proteines.
#   - num és el número de vegades que es repeteix la seqüència.
#   - Assegura't que la proteina de la seqüència original sense mutació no és al diccionari.
# - Finalment genera un array de tuples (seq, num)que contingui només
#   les 10 seqüències més comunes ordenades de més comuna a menys
#   i guarda l'array a un fitxer "answer2.json" en format json i identació 4 espais.

#theses are the random letters
bases = "ACTG"

#I get the dna from the fasta file of ex1
record = SeqIO.read("answer1.fasta", "fasta")

#getting the first 90 dna chars from the seq
record_90 = record.seq[0:90]

#first list with 100 dna seqs
new_list= []
for x in range(100):
    new_list.append(record_90)

#second list, i'll change seqs to mutable one by one, then generate a random number
#then a random letter, then i change that position in the mutable, change it back to seq
#and then appending to list2
list2 = []
for seq in new_list:
    mutable_seq = seq.tomutable()
    random_number = random.randint(0,90)
    random_letter= random.choice(bases)
    mutable_seq[random_number]= random_letter
    new_seq = mutable_seq.toseq()
    list2.append(new_seq)

#third list, just translating to prot
list3 = []
for seq in list2:
    list3.append(seq.translate())

#getting the prot seq and counting their repetitions
protein_list = [str(seq) for seq in list3]
protein_counts = Counter(protein_list)

#making a prot dict
dict_prot = {}
for protein, num in protein_counts.items():
    dict_prot[protein]= num

#final dict, i generate a tuple list and append it to the final dict
final_list = {}
protein_tuples=list(dict_prot.items())
for i in range(10):
    final_list[i] = protein_tuples[i]

#writing the file in json
with open("answer2.json", "w") as json_file:
        json_file.write(json.dumps(final_list, indent = 4))

# ---------------------------------------------------------------------
