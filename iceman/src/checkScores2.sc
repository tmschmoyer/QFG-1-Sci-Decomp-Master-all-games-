;;; Sierra Script 1.0 - (do not remove this comment)
(script# 382)
(include game.sh)
(use Main)
(use Intrface)
(use System)

(public
	checkScores2 0
)

(instance checkScores2 of Script

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 382)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				((ScriptID 39 9) loop: 1 cel: 1 setCycle: 0)
				(cls)
				(cond 
					((== ((ScriptID 39 0) notify: 8) 999)
						(Print 382 2)
					)
					(
						(and
							(== ((ScriptID 39 0) notify: 4) 0)
							(not ((ScriptID 39 0) notify: 8))
						)
						((ScriptID 39 0) notify: 8 777)
						((ScriptID 39 15) cel: 0)
						((ScriptID 39 14) cel: 6)
						(Print 382 3)
						(Print 382 4)
						(Print 382 5)
						(Print 382 6)
						(Print 382 7)
						(Print 382 8)
					)
					(
						(and
							(== ((ScriptID 39 0) notify: 4) 1)
							((ScriptID 39 0) notify: 8)
						)
						((ScriptID 39 0)
							notify: 3 (- ((ScriptID 39 0) notify: 3) 1)
						)
						(Print 382 9)
						((ScriptID 39 15) setCel: 6)
						((ScriptID 39 14) setCel: 0)
						(curRoom newRoom: 32)
						(self dispose:)
					)
					((< ((ScriptID 39 0) notify: 4) 0)
						(Print 382 10)
						(Print 382 11)
						(ego get: iDevice)
						((ScriptID 39 15) setCel: 0)
						((ScriptID 39 14) setCel: 6)
						(curRoom newRoom: 32)
						(self dispose:)
					)
					((== ((ScriptID 39 0) notify: 3) 0)
						((ScriptID 39 15) setCel: 6)
						((ScriptID 39 14) setCel: 0)
						(curRoom setScript: (ScriptID 376 1))
						(self dispose:)
					)
					(else ((ScriptID 39 0) notify: 10)
						(self dispose:)
					)
				)
			)
		)
	)
	
	(method (handleEvent event)
		(cond 
			((super handleEvent: event))
			((and (Said 'affirmative') ((ScriptID 39 0) notify: 8))
				(Print 382 0)
				(if (== ((ScriptID 39 0) notify: 8) 999)
					((ScriptID 39 0) notify: 8 0)
				)
				((ScriptID 39 0) notify: 10)
				(self dispose:)
			)
			((and (Said 'n') ((ScriptID 39 0) notify: 8))
				(Print 382 1)
				(SetCursor theCursor TRUE 310 180)
				(curRoom newRoom: 32)
				(self dispose:)
			)
		)
	)
)