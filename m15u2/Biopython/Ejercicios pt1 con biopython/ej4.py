from Bio.Seq import Seq

def make_reverse_complementary_strand(strand_in):
    
    dna = Seq(strand_in)
    rev_com_dna = dna.reverse_complement()
    res = str(rev_com_dna)
    
    return res
"""
%load_ext autoreload
%autoreload 2
"""