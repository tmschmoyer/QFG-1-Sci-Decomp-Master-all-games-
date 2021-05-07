;;; Sierra Script 1.0 - (do not remove this comment)
(script# 208)
(include sci.sh)
(use Main)
(use Intrface)
(use Game)

(public
	outsideReg 0
)

(local
	local0
	[local1 92] = [208 0 208 1 208 2 208 3 208 4 208 5 208 6 208 7 208 8 208 9 208 10 208 11 208 12 208 13 208 14 208 15 208 16 208 17 208 18 208 19 208 20 208 21 208 22 208 23 208 24 208 25 208 26 208 27 208 28 208 29 208 30 208 31 208 32 208 33 208 34 208 35 208 36 208 37 208 38 208 35 208 39 208 40 208 41 208 21 208 42 208 30]
	[local93 11] = ['examine>' 'climb>' 'get>' 'get>' 'close>' 'open>' 'dig>' 'smell>' 'bang>' 'hear>' 'drink>']
	[local104 46] = ['/acres' '/bayou' '/grass' '/mud,water' '[<down][/dirt]' '[<up][/sky,night]' '/cloud,storm' '/star' '/moon' '/bolt' '/thunder' '/oak' '/foliage' '/blossom' '/bush' '/moss' '/weed' '/drive' '<(behind,below)/blind' '/blind' '/cabin,mansion' '/bird' '/boulder' '/bug' '/oak' '/blossom' '/foliage' '/moss' '/weed' '/bird' '/drink' '/boulder' '/bug' '/water' '/cane<sugar' '/blind' '/blind' '[/eyehole,grave,cemetery[<eyehole]]' '/blossom' '[/door]' '/bug' '/wind' '/thunder' '/bird,owl' '/*,!*[/*,!*]' '[/water]']
	[local150 22] = [0 24 24 1 25 9 34 1 35 1 36 1 37 1 38 1 39 1 40 5 45 1]
	local172
	local173
	local174
)
(instance outsideReg of Rgn
	(properties)
	
	(method (init &tmp temp0 temp1)
		(super init:)
		(Load rsSOUND 12)
		(Load rsSOUND 13)
		(if
			(and
				(!= curRoomNum 1)
				(!= curRoomNum 7)
				(!= curRoomNum 8)
				(!= curRoomNum 25)
				(!= curRoomNum 30)
			)
			(= temp0 40)
			(= temp1 23)
		else
			(= temp0 23)
			(= temp1 40)
		)
		(= [local1 (= temp1 (* temp1 2))]
			[local1 (= temp0 (* temp0 2))]
		)
		(= [local1 (+ temp1 1)] [local1 (+ temp0 1)])
		(if
			(or
				(!= (cSound state?) 3)
				(== prevRoomNum 2)
				(and (== prevRoomNum 9) (== curRoomNum 2))
			)
			(cSound
				number: (if (== curRoomNum 2) 12 else 13)
				loop: -1
				priority: -1
				play:
			)
		)
	)
	
	(method (doit)
		(super doit:)
		(if (and (& global123 $0040) (== [global368 0] 2))
			(= [global368 0] 1)
			(Print 208 43)
		)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent event &tmp temp0)
		(if (event claimed?) (return))
		(if (== (event type?) evSAID)
			(= local172 0)
			(while (< local172 11)
				(if (Said [local93 local172])
					(= temp0
						(+
							[local150 (= local174 (* local172 2))]
							[local150 (+ local174 1)]
						)
					)
					(= local173 [local150 local174])
					(while (< local173 temp0)
						(if (Said [local104 local173])
							(= local173 (* local173 2))
							(Print [local1 local173] [local1 (++ local173)])
							(break)
						)
						(++ local173)
					)
				)
				(++ local172)
			)
		)
	)
)
