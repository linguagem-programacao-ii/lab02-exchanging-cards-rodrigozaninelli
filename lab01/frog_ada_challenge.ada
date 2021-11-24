with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;

procedure Hello is
    Line : String := Get_Line;
    Line2 : String := Get_Line;
    HeighDiferential : Integer;
    InitialHeigh : Integer ;
    Heigh : Integer;
    MaxJumpH : Integer;
    LastPipe : Integer;
    Last : Positive;
begin
    Get(Line(1..Line'Last),MaxJumpH,Last);
    Get(Line(2..Line'Last),LastPipe,Last);
    Get(Line2(1..Line2'Last),InitialHeigh,Last);
    Last := 1;
    while Last < LastPipe*2 loop
        Get(Line2(Last..Line2'Last),Heigh,Last);
        if Heigh > InitialHeigh then
          HeighDiferential := Heigh - InitialHeigh;
          if MaxJumpH < HeighDiferential then
            Ada.Text_IO.Put("GAME OVER");
            Last := 100000;
          end if;
        elsif Heigh < InitialHeigh then
          HeighDiferential := InitialHeigh - Heigh;
          if MaxJumpH < HeighDiferential then
            Ada.Text_IO.Put("GAME OVER");
            Last := 100000;
          end if;
        end if;
        InitialHeigh := Heigh;
       Last := Last + 1;    -- Needed to move to the next part of the string
    end loop;
    if Last < 100000 then
      Ada.Text_IO.Put("YOU WIN");
    end if;
end Hello;
