
"""
e2 tests.
"""

import pytest
import utilslib
import e2


# PEDING: 'exon' trap as an author!!

#----------------------------------------------------------------------
def test_get_exon_ranges_00():
    "get_exon_ranges() test."

    genbank_txt = ''

    with pytest.raises(ValueError):
        e2.get_exon_ranges(genbank_txt)


#----------------------------------------------------------------------
def test_get_exon_ranges_01():
    "get_exon_ranges() test: exon keyword outside of FEATUES TRAP."

    genbank_txt = utilslib.read_file('genbank/lysozyme-3-bos-taurus-trap.gbff')
    res = e2.get_exon_ranges(genbank_txt)
    ref = [(1, 144), (144, 309), (309, 385), (385, 950)]

    assert res == ref


#----------------------------------------------------------------------
def test_get_exon_ranges_02():
    "get_exon_ranges() test."

    genbank_txt = utilslib.read_file('genbank/lysozyme-1-mus-musculus.gbff')
    res = e2.get_exon_ranges(genbank_txt)
    ref = [(0, 166), (166, 331), (331, 410), (410, 1265)]

    assert res == ref


#----------------------------------------------------------------------
def test_get_exon_ranges_03():
    "get_exon_ranges() test."

    genbank_txt = utilslib.read_file('genbank/lysozyme-3-bos-taurus.gbff')
    res = e2.get_exon_ranges(genbank_txt)
    ref = [(1, 144), (144, 309), (309, 385), (385, 950)]

    assert res == ref


#----------------------------------------------------------------------
def test_get_exon_ranges_04():
    "get_exon_ranges() test."

    genbank_txt = utilslib.read_file('genbank/lysozyme-p-drosophila-melanogaster.gbff')
    res = e2.get_exon_ranges(genbank_txt)
    ref = []

    assert res == ref


#----------------------------------------------------------------------
