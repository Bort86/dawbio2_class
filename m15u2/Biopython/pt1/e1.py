

"""
e1
"""
import re

#----------------------------------------------------------------------
def get_dna_seq(genbank_txt_in: str) -> str:
    """Analyzes a genbank text string and extracts the DNA string.
    The DNA string is output in capital letters, wihtout whitespace or newlines.
    All DNA letters are allowed.
    """

    final_string = ""

    reg = r'\s'
    pat = re.compile(reg)
    first_match = re.sub(pat, "", genbank_txt_in)

    reg2 = r'ORIGIN(.*)//$'
    pat2 = re.compile(reg2)

    match = pat2.search(first_match)

    if not match:
        raise ValueError(f'No dna string founded in {genbank_txt_in}')


    second_match = match.group(1)

    reg3 = r'[0-9]'
    pat3 = re.compile(reg3)

    third_match = re.sub(pat3, "", second_match)

    final_string = third_match.upper()

    return final_string
#----------------------------------------------------------------------
