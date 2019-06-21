# - M15-UF2: (Bio)Python Pt3 (2019-01-31) (v.B)
# ---------------------------------------------------------------------
# - Nom: Pablo
# - Cognoms: Rodriguez Fraga
# - DNI: X6780502X
# ---------------------------------------------------------------------
# - Enunciat:
#   Escriu el codi necessari per resoldre els problemes en aquest fitxer.
# ---------------------------------------------------------------------

# Imports
# ---------------------------------------------------------------------

from Bio import SeqIO
from Bio.Seq import Seq
from Bio.SeqRecord import SeqRecord


# Problema 1 (5.0 punts)
# ---------------------------------------------------------------------
# - Carrega el fitxer "ls_orchid.gbk" i crea les següents variables:
#   - orchid_list (List(SeqRecord))
#     - Una llista amb tots els records del GenBank.
#     - A la llista no hi pot haver cap SeqRecord amb el mateix nom d'organisme.
#     - Si n'hi ha s'han d'esborrar *tots* els repetits i posar-los
#       a una llista anomenada "repes_list".
#   - Escull dos records de la llista "repes_list" que pertanyin al mateix organisme
#     i compara'ls. Explica breument la funció, els paràmetres i els resultats.

my_list1 = []
my_list2 = []
repes_list = []
orchid_list= []

for seq_record in SeqIO.parse("ls_orchid.gbk", "gb"):
    my_list1.append(seq_record)

my_list2 = [seq_record.annotations["organism"] for seq_record in SeqIO.parse("ls_orchid.gbk", "gb")]

for seq_record in my_list1:
    name = seq_record.annotations["organism"]
    contador = 0
    for name_2 in my_list2:
        if name == name_2:
            contador += 1
    if contador > 1:
        repes_list.append(seq_record)
    else:
        orchid_list.append(seq_record)

"""
Aquí he decidido coger los dos primeros repetidos y printar sus id y nombres, que difieren
"""
for seq_record1 in repes_list:
    for seq_record2 in repes_list:
        if seq_record1.annotations["organism"] == seq_record2.annotations["organism"]:
            print("Nombres = " + seq_record1.name + " " + seq_record2.name)
            print("id = " + seq_record1.id + " " + seq_record2.id)
            break
        break
    break


# Problema 2 (5.0 punts)
# ---------------------------------------------------------------------

# Crea una llista anomenada "orchid_protein_list"
# amb la transcripció de tots els SeqRecords.
# Afegeix un comentari a tots els SeqRecords dient el que has fet.
# Després grava'ls a disc en un únic fitxer genbank que es digui "ls_orchid_protein.gbk".
# Cada record ha de tenir com a mínim el accession number i el comentari.


# ---------------------------------------------------------------------

orchid_protein_list = []

for seq_record in SeqIO.parse("ls_orchid.gbk", "gb"):
    orchid_protein_list.append(seq_record)

for seq_record in orchid_protein_list:
    seq_record.seq = seq_record.seq.transcribe()
    seq_record.annotations["Comentario"] = "Esto es un comentario inventado"

SeqIO.write(orchid_protein_list, "ls_orchid_protein.gbk", "genbank")
