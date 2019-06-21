
"""
e1 tests.
"""

import pytest
import utilslib
import e1


#----------------------------------------------------------------------
def test_get_dna_seq_00():
    "get_dna_seq() test."

    genbank_txt = ''

    with pytest.raises(ValueError):
        e1.get_dna_seq(genbank_txt)


#----------------------------------------------------------------------
def test_get_dna_seq_01():
    "get_dna_seq() test."

    filename = 'insulin-homo-sapiens'

    genbank_txt = utilslib.read_file(f'genbank/{filename}.gbff')
    res = e1.get_dna_seq(genbank_txt)
    ref = utilslib.read_fasta(f'fasta/{filename}.fasta')[0]

    assert res == ref


#----------------------------------------------------------------------
def test_get_dna_seq_02():
    "get_dna_seq() test."

    filename = 'lysozyme-1-mus-musculus'

    genbank_txt = utilslib.read_file(f'genbank/{filename}.gbff')
    res = e1.get_dna_seq(genbank_txt)
    ref = utilslib.read_fasta(f'fasta/{filename}.fasta')[0]

    assert res == ref


#----------------------------------------------------------------------
def test_get_dna_seq_03():
    "get_dna_seq() test."

    filename = 'lysozyme-3-bos-taurus'

    genbank_txt = utilslib.read_file(f'genbank/{filename}.gbff')
    res = e1.get_dna_seq(genbank_txt)
    ref = utilslib.read_fasta(f'fasta/{filename}.fasta')[0]

    assert res == ref


#----------------------------------------------------------------------
def test_get_dna_seq_04():
    "get_dna_seq() test."

    filename = 'lysozyme-p-drosophila-melanogaster'

    genbank_txt = utilslib.read_file(f'genbank/{filename}.gbff')
    res = e1.get_dna_seq(genbank_txt)
    ref = utilslib.read_fasta(f'fasta/{filename}.fasta')[0]

    assert res == ref


#----------------------------------------------------------------------
