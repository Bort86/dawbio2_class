
"""
e3
"""
import re
#----------------------------------------------------------------------
def make_fasta_str(comment_in: str, seq_in: str) -> str:
    """Writes comment_in and seq_in to to filename_in in the FASTA format.
    The FASTA format is as follows:
    - The first line starts with a '>' and is comment_in.
    - The rest of the lines contain seq_in.
    Checks:
    - Each line must be 70 chars long.
      - The comment line can be shorter.
      - The last line can be shorter.
    - Each line must end in a newline
      - Except the last line.
      - The newline can be the 71th char.
      - There must be no blank lines.
    - If there is any kind of error, throw a ValueError exception.
    """

    start_comment = ">"

    if len(comment_in) > 69:
        raise ValueError(f'Comment too long')

    reg = r'\n'
    pat = re.compile(reg)
    match1 = pat.search(comment_in)
    match2 = pat.search(seq_in)

    if match1 or match2:
        raise ValueError(f'Bad Chars inside parameters')

    if comment_in == "" or seq_in == "":
        final_answer = start_comment

    else:
        comment_in = start_comment + comment_in

        array_seq = [str(seq_in[i:i+70]) for i in range(0, len(seq_in), 70)]
        str_seq = '\n'.join(array_seq).replace(' ', '')

        final_answer = '\n'.join((comment_in, str_seq))


    return final_answer

#----------------------------------------------------------------------
