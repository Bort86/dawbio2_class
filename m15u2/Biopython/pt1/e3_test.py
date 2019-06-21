
"""
e3 tests.
"""

import pytest
import e3


#----------------------------------------------------------------------
def test_make_fasta_str_00():
    "Empty strings."

    comment = ''
    seq = ''

    ref = '>'
    res = e3.make_fasta_str(comment, seq)

    assert res == ref


#----------------------------------------------------------------------
def test_make_fasta_str_01():
    "Standard test."

    comment = 'This is a comment'
    seq = 'GATTACA'

    ref = '>This is a comment\nGATTACA'
    res = e3.make_fasta_str(comment, seq)

    assert res == ref


#----------------------------------------------------------------------
def test_make_fasta_str_02():
    "Long seq."

    comment = 'This is a comment'
    seq = '''
    CTCGAGGGGCCTAGACATTGCCCTCCAGAGAGAGCACCCAACACCCTCCAGGCTTGACCGGCCAGGGTGT
    CCCCTTCCTACCTTGGAGAGAGCAGCCCCAGGGCATCCTGCAGGGGGTGCTGGGACACCAGCTGGCCTTC
    AAGGTCTCTGCCTCCCTCCAGCCACCCCACTACACGCTGCTGGGATCCTGGATCTC
    '''.replace(' ', '').replace('\n', '')

    ref = (
        '>This is a comment\n'
        'CTCGAGGGGCCTAGACATTGCCCTCCAGAGAGAGCACCCAACACCCTCCAGGCTTGACCGGCCAGGGTGT\n'
        'CCCCTTCCTACCTTGGAGAGAGCAGCCCCAGGGCATCCTGCAGGGGGTGCTGGGACACCAGCTGGCCTTC\n'
        'AAGGTCTCTGCCTCCCTCCAGCCACCCCACTACACGCTGCTGGGATCCTGGATCTC')

    res = e3.make_fasta_str(comment, seq)
    assert res == ref


#----------------------------------------------------------------------
def test_make_fasta_str_03():
    "Error: Long comment."

    comment = ('This is a veeeeeeeeeeeery looooooooooooooooooong comment '
               'and it will trigger an error in make_fasta_str()!!!!')
    seq = 'GATTACA'

    with pytest.raises(ValueError):
        e3.make_fasta_str(comment, seq)


#----------------------------------------------------------------------
def test_make_fasta_str_04():
    "Error: Comment with newlines."

    comment = 'Comment\nwith\nnewlines\n.'
    seq = 'GATTACA'

    with pytest.raises(ValueError):
        e3.make_fasta_str(comment, seq)


#----------------------------------------------------------------------
def test_make_fasta_str_05():
    "Error: Sequence with newlines."

    comment = 'Comment.'
    seq = 'GAT\nTAC\nA\n\n'

    with pytest.raises(ValueError):
        e3.make_fasta_str(comment, seq)


#----------------------------------------------------------------------
