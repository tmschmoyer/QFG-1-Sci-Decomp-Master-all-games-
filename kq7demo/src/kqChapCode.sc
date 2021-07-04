;;; Sierra Script 1.0 - (do not remove this comment)
(script# 28)
(include game.sh)
(use Main)
(use Procs)
(use ScaryInventory)
(use System)

(public
	kqChapCode 0
)

(instance kqChapCode of Code
	
	(method (doit whatChapter nRoom &tmp temp0 temp1 temp2)
		(if argc
			(= temp2 1)
			(= curChapter whatChapter)
		else
			(= temp2 0)
			(++ curChapter)
		)
		(if (mod curChapter 2)
			(= global104 -4)
		else
			(= global104 -3)
		)
		(if (and temp2 nRoom)
			(curRoom newRoom: nRoom)
		else
			(inventory eachElementDo: #hide)
			(FrameOut)
			(= global171 0)
			(= temp0 0)
			(while (< temp0 (inventory size:))
				(if
				((= temp1 (inventory at: temp0)) ownedBy: global104)
					(proc18_1 temp1)
				)
				(= temp0 (+ temp0 1))
			)
			(switch curChapter
				(1
					(ego get: 0)
					(if nRoom
						(curRoom newRoom: nRoom)
					else
						(curRoom newRoom: 100)
					)
				)
				(2
					(if (and temp2 (Btst 8))
						(Bset 6)
						(Bset 9)
						(Bset 12)
						(Bset 13)
						(Bset 14)
						(Bset 15)
						(Bset 24)
						(Bset 25)
						(Bset 27)
						(Bset 28)
						(Bset 32)
						(Bset 37)
						(Bset 41)
						(Bset 43)
					)
					(Bclr 8)
					(if (and temp2 nRoom)
						(curRoom newRoom: nRoom)
					else
						(curRoom newRoom: 2470)
					)
				)
				(3
					(if (and temp2 (Btst 8))
						(Bset 6)
						(Bset 9)
						(Bset 12)
						(Bset 13)
						(Bset 14)
						(Bset 15)
						(Bset 24)
						(Bset 25)
						(Bset 27)
						(Bset 28)
						(Bset 32)
						(Bset 37)
						(Bset 41)
						(Bset 43)
						(Bset 50)
						(Bset 51)
						(Bset 52)
						(Bset 53)
						(Bset 54)
						(Bset 55)
						(Bset 56)
						(Bset 57)
						(Bset 58)
						(Bset 59)
						(Bset 60)
						(Bset 61)
						(Bset 62)
						(Bset 63)
						(Bset 64)
						(Bset 65)
						(Bset 66)
						(Bset 67)
						(ego
							get: 0
							get: 1
							get: 7
							get: 21
							get: 3
							get: 2
							get: 20
							get: 10
						)
					)
					(Bclr 8)
					(if (and temp2 nRoom)
						(curRoom newRoom: nRoom)
					else
						(curRoom newRoom: 1000)
					)
				)
				(4
					(if (and temp2 (Btst 8))
						(Bset 6)
						(Bset 9)
						(Bset 12)
						(Bset 13)
						(Bset 14)
						(Bset 15)
						(Bset 24)
						(Bset 25)
						(Bset 27)
						(Bset 28)
						(Bset 32)
						(Bset 37)
						(Bset 41)
						(Bset 43)
						(Bset 50)
						(Bset 51)
						(Bset 52)
						(Bset 53)
						(Bset 54)
						(Bset 55)
						(Bset 56)
						(Bset 57)
						(Bset 58)
						(Bset 59)
						(Bset 60)
						(Bset 61)
						(Bset 62)
						(Bset 63)
						(Bset 64)
						(Bset 65)
						(Bset 66)
						(Bset 67)
						(Bset 92)
						(Bset 93)
						(Bset 95)
						(Bset 97)
						(Bset 102)
						(Bset 103)
						(Bset 105)
						(Bset 112)
						(Bset 114)
						(Bset 117)
						(Bset 118)
						(Bset 119)
						(Bset 94)
						(ego get: 28 get: 31 get: 38)
					)
					(Bclr 8)
					(if (and temp2 nRoom)
						(curRoom newRoom: nRoom)
					else
						(curRoom newRoom: 4050)
					)
				)
				(5
					(if (and temp2 (Btst 8))
						(Bset 6)
						(Bset 9)
						(Bset 12)
						(Bset 13)
						(Bset 14)
						(Bset 15)
						(Bset 24)
						(Bset 25)
						(Bset 27)
						(Bset 28)
						(Bset 32)
						(Bset 37)
						(Bset 41)
						(Bset 43)
						(Bset 50)
						(Bset 51)
						(Bset 52)
						(Bset 53)
						(Bset 54)
						(Bset 55)
						(Bset 56)
						(Bset 57)
						(Bset 58)
						(Bset 59)
						(Bset 60)
						(Bset 61)
						(Bset 62)
						(Bset 63)
						(Bset 64)
						(Bset 65)
						(Bset 66)
						(Bset 67)
						(Bset 92)
						(Bset 93)
						(Bset 95)
						(Bset 97)
						(Bset 102)
						(Bset 103)
						(Bset 105)
						(Bset 112)
						(Bset 114)
						(Bset 117)
						(Bset 118)
						(Bset 119)
						(Bset 94)
						(Bset 142)
						(Bset 144)
						(Bset 146)
						(Bset 147)
						(Bset 148)
						(Bset 149)
						(Bset 151)
						(Bset 152)
						(Bset 171)
						(Bset 172)
						(Bclr 157)
						(Bset 158)
						(Bset 159)
						(Bset 160)
						(Bset 161)
						(Bset 163)
						(Bset 164)
						(Bset 165)
						(Bset 173)
						(Bset 174)
						(ego get: 0 get: 47 get: 48 get: 10 get: 3 get: 46)
					)
					(Bclr 8)
					(if (and temp2 nRoom)
						(curRoom newRoom: nRoom)
					else
						(curRoom newRoom: 5100)
					)
				)
				(6
					(if (and temp2 (Btst 8))
						(Bset 6)
						(Bset 9)
						(Bset 12)
						(Bset 13)
						(Bset 14)
						(Bset 15)
						(Bset 24)
						(Bset 25)
						(Bset 27)
						(Bset 28)
						(Bset 32)
						(Bset 37)
						(Bset 41)
						(Bset 43)
						(Bset 50)
						(Bset 51)
						(Bset 52)
						(Bset 53)
						(Bset 54)
						(Bset 55)
						(Bset 56)
						(Bset 57)
						(Bset 58)
						(Bset 59)
						(Bset 60)
						(Bset 61)
						(Bset 62)
						(Bset 63)
						(Bset 64)
						(Bset 65)
						(Bset 66)
						(Bset 67)
						(Bset 92)
						(Bset 93)
						(Bset 95)
						(Bset 97)
						(Bset 102)
						(Bset 103)
						(Bset 105)
						(Bset 112)
						(Bset 114)
						(Bset 117)
						(Bset 118)
						(Bset 119)
						(Bset 94)
						(Bset 142)
						(Bset 144)
						(Bset 146)
						(Bset 147)
						(Bset 148)
						(Bset 149)
						(Bset 151)
						(Bset 152)
						(Bset 171)
						(Bset 172)
						(Bclr 157)
						(Bset 158)
						(Bset 159)
						(Bset 160)
						(Bset 161)
						(Bset 163)
						(Bset 164)
						(Bset 165)
						(Bset 174)
						(Bset 173)
						(Bset 192)
						(Bset 194)
						(Bset 196)
						(Bset 198)
						(Bset 199)
						(Bset 200)
						(Bset 202)
						(Bset 203)
						(Bset 204)
						(Bset 206)
						(Bset 209)
						(Bset 211)
						(Bset 214)
						(Bset 215)
						(Bset 216)
						(ego get: 56 get: 60 get: 62 get: 58 get: 53)
					)
					(Bclr 8)
					(if (and temp2 nRoom)
						(curRoom newRoom: nRoom)
					else
						(curRoom newRoom: 2200)
					)
				)
			)
		)
	)
)
