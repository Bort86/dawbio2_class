from Bio.Seq import Seq

import ej4

def is_dna_palindrome(strand_in):
    
    final_answer = False
    
    reversed_complementary = ej4.make_reverse_complementary_strand(strand_in)
    
    if(reversed_complementary == strand_in):
        final_answer = True
    
    return final_answer
