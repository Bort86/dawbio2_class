from Bio.Seq import Seq
from Bio.Alphabet import IUPAC
import Bio.Alphabet

def is_dna_strand(strand_in):
    dna = Seq(strand_in, IUPAC.unambiguous_dna)
    res = Bio.Alphabet._verify_alphabet(dna)
    return res