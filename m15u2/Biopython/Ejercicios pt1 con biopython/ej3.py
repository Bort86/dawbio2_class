from Bio.Seq import Seq

def make_complementary_strand(strand_in):
    
    dna = Seq(strand_in)
    com_dna = dna.complement();
    res = str(com_dna)
    
    return res