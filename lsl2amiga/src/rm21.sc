;;; Sierra Script 1.0 - (do not remove this comment)
(script# 21)
(include game.sh)
(use Main)
(use Intrface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm21 0
)

(instance rm21 of Room
	(properties
		picture 21
		horizon 146
		north 17
		east 22
		south 25
		west 20
	)
	
	(method (init)
		(Load VIEW 241)
		(super init:)
		(aView1
			loop: 1
			cel: 0
			setPri: 10
			ignoreActors:
			addToPic:
		)
		(aView2
			loop: 1
			cel: 1
			setPri: 9
			ignoreActors:
			addToPic:
		)
		(aSign
			setLoop: 0
			setPri: 5
			setCycle: Forward
			cycleSpeed: 3
			init:
		)
		(cond 
			((== prevRoomNum 25)
				(ego posn: 222 187)
			)
			((or (== prevRoomNum 0) (== prevRoomNum 17))
				(ego posn: 264 149)
			)
			((== prevRoomNum 115)
				(ego loop: 0 posn: 178 177)
			)
		)
		(NormalEgo)
		(ego init:)
		(self setRegions: CITY setScript: rm21Script)
	)
)

(instance rm21Script of Script
	(method (doit)
		(super doit:)
	)
	
	(method (handleEvent event)
		(if (or (!= (event type?) saidEvent) (event claimed?))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/barrel,carpet,freeway')
				(Print 21 0)
			)
			(if (Said '/bar')
				(Print 21 1)
			)
			(if (Said '/sign')
				(Print 21 2)
			)
			(if (Said '/graffiti')
				(Print 21 3)
			)
			(if (Said '[/building,airport]')
				(Print 21 4)
			)
		)
	)
)

(instance aView1 of View
	(properties
		y 138
		x 296
		view 241
	)
)

(instance aView2 of View
	(properties
		y 134
		x 259
		view 241
	)
)

(instance aSign of Prop
	(properties
		y 87
		x 302
		view 241
	)
)