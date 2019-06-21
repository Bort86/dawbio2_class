#!/usr/bin/env python3

"""
Practica
"""

from typing import List, Tuple
import sys

import utilslib
import e1
import e2
import e3
import click


#----------------------------------------------------------------------
def get_exons(genbank_txt_in: str) -> List[str]:
    """Analyzes the text of a genbank file and returns an array of exons.
    Each exon is a string of nucleotides.
    """

    dna_seq = e1.get_dna_seq(genbank_txt_in)
    exon_ranges = e2.get_exon_ranges(genbank_txt_in)

    exons = [dna_seq[start:end] for start, end in exon_ranges]

    res = exons
    return res


#----------------------------------------------------------------------
def make_exons_fasta_str(exons: List[str]) -> str:
    """Translates a list of exon dna sequences into a single fasta string.
    - Each exon starts with a comment line like this: >exon
    - Each exon is separated by a blank line from other exons.
    - The last exon does not have any whitespace nor newlines at the end.
    """

    fasta_arr = [e3.make_fasta_str('exon', exon) for exon in exons]
    fasta_str = '\n\n'.join(fasta_arr)

    res = fasta_str
    return res


#----------------------------------------------------------------------

@click.command()
@click.argument('genbank_filename_in')
@click.argument('fasta_filename_out')

def main(genbank_filename_in: str, fasta_filename_out):
    """Reads genbank_filename_in and writes its exons into fasta_filename_in.
    - Each exon starts with a comment line like this: >exon
    - Each exon is separated by a blank line from other exons.
    - The last exon does not have any whitespace nor newlines at the end.
    """

    genbank_txt = utilslib.read_file(genbank_filename_in)
    exons = get_exons(genbank_txt)
    fasta_str = make_exons_fasta_str(exons)
    utilslib.write_file(fasta_str, fasta_filename_out)

if __name__ == "__main__":
    main()

"""
def parse_cmdline(args: List[str]) -> Tuple[str, str]:
    Parses the cmdline arguments. Args must not contain the executable name.
    Returns two strings:
    - genbank_filename_in
    - fasta_filename_out
    Throws ValueError if arguments are missing.


    if len(args) != 2:
        raise ValueError("Exactly two arguments are needed")

    genbank_filename_in = args[0]
    fasta_filename_out = args[1]

    res = (genbank_filename_in, fasta_filename_out)
    return res


#----------------------------------------------------------------------
#print(__name__)

if __name__ == "__main__":
    
    try:
        GENBANK_FILENAME, FASTA_FILENAME = parse_cmdline(sys.argv[1:])
    except ValueError:
        sys.stderr.write("Cmdline error: Two args required. No more, no less.\n")
        sys.stderr.write("Usage: main 'genbank_filename_in' 'fasta_filename_out'\n")
    else:
        main(GENBANK_FILENAME, FASTA_FILENAME)


#----------------------------------------------------------------------
"""
