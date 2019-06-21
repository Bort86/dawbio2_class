
"""
e2
"""

from typing import List, Tuple

import re

#----------------------------------------------------------------------
def get_exon_ranges(genbank_txt_in: str) -> List[Tuple[int, int]]:
    """Analyzes the text of a genbank file and returns the ranges of the exons.
    Each range is a tuple of ints (start, end).
    Each tuple is like a python range.
    - Indexes start at zero.
    - The end index is excluded.
    Note that this is different from the genbank file format:
    - Indexes start at one.
    - The end index is included.
    """
    if not genbank_txt_in:
        raise ValueError(f'Empty File')

    reg = r'\sFEATURES(.*)ORIGIN'
    pat = re.compile(reg, re.DOTALL)
    matches = pat.search(genbank_txt_in)

    if not matches:
        raise ValueError(f'No exon founded in file {genbank_txt_in}')

    str_exons = matches.group(1)

    reg2 = r'exon\s*([0-9]+)\.\.([0-9]+)'
    pat2 = re.compile(reg2)
    matches2 = pat2.finditer(str_exons)

    #Final answer is an array where i'll save the tuples composed by exons
    #first, I do a for each to iterate through 'matches', which is a callable iterator
    #reading it with the for allows me to read each match as an independent object, so
    #i can get its attribute 'group' then we transform each match to int
    #and save it in the tuple

    array_exon = [(int(e.group(1))-1, int(e.group(2))) for e in matches2]

    return array_exon
#----------------------------------------------------------------------

def get_exon_ranges_v2(genbank_txt_in: str) -> List[Tuple[int, int]]:
    """
    This is just a test I wanted to try
    I use a 'wrong' regex to filter exons, I wanted to focus
    on iterating on the object 'matches' to try to comprehend it
    """
    if not genbank_txt_in:
        raise ValueError(f'Empty File')

    reg = r'exon\s*([0-9]+)\.\.([0-9]+)$'
    pat = re.compile(reg, re.MULTILINE)
    matches = pat.finditer(genbank_txt_in)

    if not matches:
        raise ValueError(f'No exon founded in file {genbank_txt_in}')

    # I declare an empty array

    array_exon = []

    #Then I save all the matches, which are in the callable iterator 'matches'
    #in a list, so I can iterate through it

    lista1 = list(matches)

    #Then I iterate through the list of matches and save each exon
    #then save the exon pairs in a tuple and append that tuple to the empty array

    for i in lista1:
        int_one = int(i.group(1))-1
        int_two = int(i.group(2))
        int_final = (int_one, int_two)

        array_exon.append(int_final)

    return array_exon
#---------------------------------------------------------------------
