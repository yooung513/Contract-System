<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
      <update id="update" parameterType="borad">
          UPDATE BOARD
            SET BOARD_NEWSID = #{newsId},
                BOARD_MATCODE = # {matCode},
                BOARD_DATE = # {date},
                BOARD_TITLE = # {title},
                BOARD_HYPERLINK = # {hyperlink},
                BOARD_CONTENTS = # {contents},
                BOARD_REGISTER = # {register},
                BOARD_REGDATE = # {regDate},
          WHERE BOARD_REGCODE = # {regCode},
      </update>
</body>
</html>