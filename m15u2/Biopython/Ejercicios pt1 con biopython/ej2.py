from Bio.Seq import Seq

def reverse_strand(strand_in):
    dna = Seq(strand_in)
    rev_dna = dna[::-1]
    res = str(rev_dna)
    return res    