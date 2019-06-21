
"""
UtilsLib.
"""

from typing import List
import re


#----------------------------------------------------------------------
def read_file(filename_in: str) -> str:
    """Reads filename_in and returns its contents as a string."""

    with open(filename_in, 'r') as text_file:
        contents_str = text_file.read()

    return contents_str


#----------------------------------------------------------------------
def write_file(str_in: str, filename_in: str):
    """Writes str_in to filename_in."""

    with open(filename_in, 'w') as text_file:
        text_file.write(str_in)


#----------------------------------------------------------------------
def read_fasta(filename_in: str) -> List[str]:
    """Reads a FASTA file and returns the DNA strings.
    - Supports multiple records.
    - Returns the empty array if can't find valid DNA strings.
    """

    # Read file
    txt = read_file(filename_in)

    # Parse
    reg = r'^>.*\n([ATCGN\n]*)'
    pat = re.compile(reg, re.MULTILINE)
    matches = pat.finditer(txt)

    # Cleanup
    dna_nl_str_arr = [m.group(1) for m in matches]
    dna_str_arr = [nl_str.replace('\n', '') for nl_str in dna_nl_str_arr]

    # Return
    res = dna_str_arr
    return res


#----------------------------------------------------------------------
